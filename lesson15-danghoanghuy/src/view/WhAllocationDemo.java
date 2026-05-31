package view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import bean.Item;
import bean.Store;
import model.DataModel;

public class WhAllocationDemo {
	
	public static void main(String[] args) {
		
		// Step 1: Check for planning amount
		int planningAmount = DataModel.planningAmount;
		int requiredMinPlanningAmount = DataModel.requiredMinPlanningAmount;
		int minPerStore = DataModel.minPerStore;
		
		if (planningAmount <= requiredMinPlanningAmount) {
			System.out.println("Stop calculation");
			return;
		}
		
		// Step 2: Filling gaps by references or average
		Map<Integer, Store> storeMap = fillGap();
		storeMap.forEach((id, store) -> {
				System.out.println("Id: " + id + ", Potential: " + store.getPotential());
		});
		
		// Step 3: Calculate Store Demand of current Item(Item A1)
		// Demand = (("Potential A55" * Weight A55 +"Potential A77" * Weight A77) /  (Weight A55 + Weight A77)) * Store Trend
		Map<Integer, BigDecimal> trendFactors = DataModel.mockStoreTrendFactors();
		Map<Integer, BigDecimal> refWeights = DataModel.mockRefWeights();
		List<Item> refItems = List.of(new Item(55, " Reference Item A55"), new Item(77, " Reference Item A77"));
		Map<Item, List<Store>> refPotentials = Map.of(new Item(55, " Reference Item A55"), 
				DataModel.mockStoresOfRefItemA55().get(new Item(55, " Reference Item A55")),
				new Item(77, " Reference Item A77"),
				DataModel.mockStoresOfRefItemA77().get(new Item(77, " Reference Item A77"))
				);
		
		Map<Integer, BigDecimal> storeDemand = calculateStoreDemand(trendFactors, refWeights, refItems, refPotentials, storeMap);
		storeDemand.forEach((store, demand) -> {
			System.out.println("Store: " + store + ", Demand: " + demand);
		});
		
		// Step 4: Sum up Demand to WH Level  
		//Demand WH = SUM(Demand Store of the respective WH)
		Map<Integer, BigDecimal> sumUpDemandToWH = sumUpDemandToWHLevel(storeMap, storeDemand);
		sumUpDemandToWH.forEach((whId, demand) -> {
			System.out.println("whId: " + whId + ", Total demand: " + demand);
		});
		
		// Step 5:Calculate Shares
		Map<Integer, BigDecimal> calcShares = calculateShares(sumUpDemandToWH);
		calcShares.forEach((whId, shares) -> {
			System.out.println("whId: " + whId + ", Shares: " + shares);
		});
		
		// Step 6: Allocate by Shares
		Map<Integer, BigDecimal> allocate = allocateByShares(calcShares, planningAmount);
		allocate.forEach((whId, alloc) -> {
			System.out.println("whId: " + whId + ", Allocate by Shares: " + alloc);
		});
		
		// Step 7: Apply Minimum
		Map<Integer, BigDecimal> applyMinimum = calcMinimum(storeMap,minPerStore);
		applyMinimum.forEach((whId, min) -> {
			System.out.println("whId: " + whId + ", Apply Minimum: " + min);
		});
		
		// Step 8: Recalculate Share
		
	}
	
	//=============================================
	// Step 2
	private static Map<Integer, Store> fillGap() {
		
		Map<Integer, Store> rs = new HashMap<>();
		
		DataModel.mockStoresOfRefItemA55().values().
		forEach(stores -> stores.forEach(store -> rs.put(store.getId(), store)));
		
		DataModel.mockStoresOfRefItemA77().values().
		forEach(stores -> stores.forEach(store -> rs.putIfAbsent(store.getId(), store)));
		
		Map<Integer, Integer> refStores = DataModel.mockRefStores();
		BigDecimal avg = rs.values().stream()
									.filter(store -> store.getPotential().compareTo(BigDecimal.ZERO) > 0)
									.map(store -> store.getPotential())
									.reduce(BigDecimal.ZERO, BigDecimal::add)
									.divide(BigDecimal.valueOf(rs.size()), RoundingMode.HALF_UP);
		rs.forEach((storeId, store) -> {
			if(store.getPotential() != null || store.getPotential().compareTo(BigDecimal.ZERO) != 0) {
				Integer refStoreId = refStores.get(storeId);
				if(refStoreId != null && rs.containsKey(refStoreId)) {
					store.setPotential(rs.get(refStoreId).getPotential());
				}
				else store.setPotential(avg);
			}
		});
		return rs;
	}
	
	// Step 3
	// Demand = (("Potential A55" * Weight A55 +"Potential A77" * Weight A77) /  (Weight A55 + Weight A77)) * Store Trend
	private static Map<Integer, BigDecimal> calculateStoreDemand(Map<Integer, BigDecimal> trendFactors,
																Map<Integer, BigDecimal> refWeights,
																List<Item> refItems,
																Map<Item, List<Store>> refPotentials,
																Map<Integer, Store> storeMap){
		
		Map<Integer, BigDecimal> storeDemand = new HashMap<>();
		
		storeMap.forEach((storeId, store) -> {
			BigDecimal trendFactor = trendFactors.getOrDefault(storeId, BigDecimal.ONE);
			BigDecimal top = BigDecimal.ZERO;
			BigDecimal bot = BigDecimal.ZERO;
			
			for(Item refItem: refItems) {
				BigDecimal refWeight = refWeights.getOrDefault(refItem.getId(), BigDecimal.ONE);
				List<Store> refStores = refPotentials.getOrDefault(refItem, Collections.emptyList());
				Optional<Store> matchStore = refStores.stream().filter(refStore -> refStore.getId() == store.getId()).findFirst();
				
				if(matchStore.isPresent()) {
					BigDecimal potential = matchStore.get().getPotential();
					top = top.add(potential.multiply(refWeight));
					bot = bot.add(refWeight);

				}
				
			}
			
			BigDecimal demand = bot.compareTo(BigDecimal.ZERO) > 0 
					? top.divide(bot, RoundingMode.HALF_UP).multiply(trendFactor) : BigDecimal.ZERO;
			storeDemand.put(storeId, demand);
		});
		
		return storeDemand;
	}
	
	// Step 4
	//Demand WH = SUM(Demand Store of the respective WH)
	private static Map<Integer, BigDecimal> sumUpDemandToWHLevel(Map<Integer, Store> storeMap, Map<Integer, BigDecimal> storeDemand){
		
		Map<Integer, BigDecimal> wh = new HashMap<>();
		storeMap.forEach((storeId, store) -> {
			BigDecimal demand = storeDemand.get(storeId);
			int whId = store.getWhId();
			
			if(wh.containsKey(whId)) {
				BigDecimal oldTotal = wh.get(whId);
				BigDecimal newTotal = oldTotal.add(demand);
				wh.put(whId, newTotal);
			}
			else wh.put(whId, demand);
		});
		
		return wh;
	} 
	
	// Step 5
	// Share WH = (Demand WH of the respective WH / Sum(Demand WH of all WH of the country)) * 100
	private static Map<Integer, BigDecimal> calculateShares(Map<Integer, BigDecimal> sumUpDemandToWH){
		
		BigDecimal totalDemand = sumUpDemandToWH.values().stream()
														.reduce(BigDecimal.ZERO, BigDecimal::add);
		Map<Integer, BigDecimal> calcShares = new HashMap<>();
		
		sumUpDemandToWH.forEach((whId, demand) -> {
			BigDecimal shares = demand.divide(totalDemand, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
			calcShares.put(whId, shares);
		});
		
		return calcShares;
	}
	
	// Step 6
	// Allocation Amount WH = Share WH / 100 * Planning Amount  Country
	private static Map<Integer, BigDecimal> allocateByShares(Map<Integer, BigDecimal> calcShares, int planningAmount){
		
		Map<Integer, BigDecimal> allocationAmount = new HashMap<>();
		
		calcShares.forEach((whId, shares) -> {
			BigDecimal alloc = shares.divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(planningAmount));
			allocationAmount.put(whId, alloc);
		});
		
		return allocationAmount;
	}
	
	// Step 7
	// This step is only needed if in Step 7 the Minimum needed to be applied for at least on WH.
	private static Map<Integer, BigDecimal> calcMinimum(Map<Integer, Store> storeMap, int minPerStore){
		Map<Integer, BigDecimal> min = new HashMap<>();
		
		for(Store store: storeMap.values()) {
			int whId = store.getWhId();
			
			if(min.containsKey(whId)){
				BigDecimal currentMin = min.get(whId);
				min.put(whId, currentMin.add(BigDecimal.valueOf(minPerStore)));
			}
			else min.put(whId, BigDecimal.valueOf(minPerStore));
		}
		
		return min;
	}
	
	// Step 8 
}
