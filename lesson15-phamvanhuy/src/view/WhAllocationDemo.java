package view;

import static utils.NumberUtils.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.Item;
import bean.Store;
import model.DataModel;

public class WhAllocationDemo {
	private static final int SCALE = 10;
	private static final RoundingMode RM = RoundingMode.HALF_UP;
	
	public static void main(String[] args) {
		System.out.println("==== Step 1: check planning amount ====");
		int planningAmount = DataModel.planningAmount;
		int requiredMin = DataModel.requiredMinPlanningAmount;
		
		System.out.println("Planning Amout = " + planningAmount);
		System.out.println("Required Min   = " + requiredMin);
		
		if(planningAmount <= requiredMin) {
			System.out.println("Planning amout <= required min --> stop");
			return;
		}
		System.out.println("OK --> Continue");
		
		Map<Item, List<Store>> refA55Map = DataModel.mockStoresOfRefItemA55();
		Map<Item, List<Store>> refA77Map = DataModel.mockStoresOfRefItemA77();
		Map<Integer, BigDecimal> weights = DataModel.mockRefWeights();
		Map<Integer, Integer> refStores  = DataModel.mockRefStores();
		Map<Integer, BigDecimal> trendFactors = DataModel.mockStoreTrendFactors();
		
		Map.Entry<Item, List<Store>> entryA55 = refA55Map.entrySet().iterator().next();
		Map.Entry<Item, List<Store>> entryA77 = refA77Map.entrySet().iterator().next();
		
		Item itemA55 = entryA55.getKey();
		Item itemA77 = entryA77.getKey();
		
		List<Store> storesA55 = entryA55.getValue();
		List<Store> storesA77 = entryA77.getValue();
		
		Map<Integer, BigDecimal> potentialA55 = storesA55.stream().collect(Collectors.toMap(Store::getId, Store::getPotential));
		Map<Integer, BigDecimal> potentialA77 = storesA77.stream().collect(Collectors.toMap(Store::getId, Store::getPotential));
		
		List<Integer> allStoreIds = storesA55.stream().map(Store::getId).sorted().toList();
		
		Map<Integer, Integer> storeWhMap = storesA55.stream().collect(Collectors.toMap(Store::getId, Store::getWhId));
		
		System.out.println("==== Step 2: Filling gaps by references or average  ");
		Map<Integer, BigDecimal> filledA55 = fillPotential(potentialA55, refStores, itemA55.getId(),weights);
		Map<Integer, BigDecimal> filledA77 = fillPotential(potentialA77, refStores, itemA77.getId(),weights);
		
		for(Integer storeId : allStoreIds ) {
			 System.out.println("Store: " + storeId);
			 System.out.println("Potential A55: " + filledA55.get(storeId));
			 System.out.println("Potential A77: " + filledA77.get(storeId));
			 System.out.println("-----------------------------");
		}
		System.out.println("==== Step 3: Calculate Store Demand of current Item(Item A1)  ");
		
		BigDecimal weightA55 = weights.get(itemA55.getId());
		BigDecimal weightA77 = weights.get(itemA77.getId());
		BigDecimal totalWeight = weightA55.add(weightA77);
		
		Map<Integer, BigDecimal> storeDemand = new HashMap<>();
		
		for(Integer storeId : allStoreIds) {
			BigDecimal pot55 = filledA55.get(storeId);
			BigDecimal pot77 = filledA77.get(storeId);
			BigDecimal trend = trendFactors.getOrDefault(storeId, ONE);
			
			BigDecimal weightedSum = pot55.multiply(weightA55).add(pot77.multiply(weightA77));
			
			BigDecimal demand = weightedSum.divide(totalWeight, SCALE , RM).multiply(trend);
			
			demand = round1(demand);
			
			storeDemand.put(storeId, demand);
			
			System.out.println("Store: " + storeId);
			System.out.println("Trend: " + trend);
			System.out.println("Potential A55: " + pot55);
			System.out.println("Potential A77: " + pot77);
			System.out.println("Demand: " + demand);
			System.out.println("-------------------------------");
		}
		
		System.out.println("==== Step 4: Sum up Demand to WH Level   ");
		
		Map<Integer, List<Integer>> whStoreMap = allStoreIds.stream().collect(Collectors.groupingBy(storeWhMap::get));
		
		List<WhResult> whResults = whStoreMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(entry -> {
			Integer whId = entry.getKey();
			List<Integer> storeIds = entry.getValue();
			WhResult result = new WhResult(whId);
			result.setAmountOfStores(storeIds.size());
			
			BigDecimal totalDemand = storeIds.stream().map(storeDemand::get).reduce(ZERO, BigDecimal::add);
			result.setDemand(totalDemand);
			return result;
			
		}).collect(Collectors.toCollection(ArrayList::new));
		
		for(WhResult wh : whResults) {
			System.out.println("Wh: " + wh.getWhId());
			System.out.println("Stores: " + wh.getAmountOfStores());
			System.out.println("Demand: " + wh.getDemand());
			System.out.println("--------------------------");
		}
		
		System.out.println("==== Step 5: Calculate Shares  ");
		
		BigDecimal totalDemandAll = whResults.stream().map(WhResult::getDemand).reduce(ZERO, BigDecimal::add);
		for (WhResult wh : whResults) {
			BigDecimal share = wh.getDemand().divide(totalDemandAll, SCALE, RM).multiply(HUNDRED);
			
			wh.setShare(share);
			
			System.out.println("WH: " + wh.getWhId());
			System.out.println("Share: " + share + "%") ;
			System.out.println("--------------------------");
		}
		
		System.out.println("==== Step 6: Allocate by Shares  ");
		
		BigDecimal planning = new BigDecimal(planningAmount);
		
		for(WhResult wh : whResults) {
			BigDecimal allocation = wh.getShare().divide(HUNDRED, SCALE, RM).multiply(planning);
			
			wh.setAllocation(allocation);
			
			System.out.println("Wh: " + wh.getWhId());
			System.out.println("Allocation: " + allocation);
			System.out.println("----------------------------------");
		}
		
		System.out.println("==== Step 7: Allocate by Shares  ");
		
		
	}
	private static Map<Integer, BigDecimal> fillPotential(
			Map<Integer, BigDecimal> rawPotential, 
			Map<Integer, Integer> refStores, 
			Integer refItemId,
			Map<Integer, BigDecimal> weights
			){
		List<BigDecimal> ownPotentials = rawPotential.values().stream().filter(p -> p.compareTo(ZERO) > 0).toList();
		
		BigDecimal average = ZERO;
		if(!ownPotentials.isEmpty()) {
			BigDecimal sum = ownPotentials.stream().reduce(ZERO, BigDecimal::add);
			average = round1(sum.divide(new BigDecimal(ownPotentials.size()), SCALE,RoundingMode.HALF_UP));
		}
		
		Map<Integer, BigDecimal> filled = new HashMap<>();
		for(Map.Entry<Integer, BigDecimal> entry : rawPotential.entrySet()) {
			Integer storeId = entry.getKey();
			BigDecimal pot = entry.getValue();
			
			if(pot.compareTo(ZERO) > 0) {
				filled.put(storeId, round1(pot));
			}else {
				Integer refStoreId = refStores.get(storeId);
				if(refStoreId != null) {
					BigDecimal refPot = rawPotential.get(refItemId);
					if(refPot != null && refPot.compareTo(ZERO) > 0) {
						filled.put(storeId, round1(refPot));
					}else {
						filled.put(storeId, average);
					}
				}else {
					filled.put(storeId, average);
				}
			}
		}
		return filled;
	}
}
