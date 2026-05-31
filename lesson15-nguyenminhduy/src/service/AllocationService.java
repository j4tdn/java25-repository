package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Store;
import bean.StoreDemand;
import bean.whAllocation;
import view.WhAllocationDemo;

public class AllocationService {

	public boolean checkpalnningAmount(int planningAmount, int requiredmin) {
		return planningAmount > requiredmin;
	}
	
	public void fillGaps(List<Store> stores, Map<Integer,Integer> refStoresMap) {
		BigDecimal totalPotential = BigDecimal.ZERO;
		int countvalidStrores = 0;
		
		for(Store s : stores) {
			if(s.getPotential().compareTo(BigDecimal.ZERO) > 0) {
				totalPotential = totalPotential.add(s.getPotential());
				countvalidStrores++;
			}
		}
		
		BigDecimal averagePotential = BigDecimal.ZERO;
		if(countvalidStrores > 0) {
			averagePotential = totalPotential.divide(new BigDecimal(countvalidStrores), 1, RoundingMode.HALF_UP);
		}
		
		for(Store s : stores) {
			if(s.getPotential().compareTo(BigDecimal.ZERO) == 0) {
				Integer refStoreId = refStoresMap.get(s.getId());
				
				if(refStoreId != null) {
					Store refStore = findStoreById(stores, refStoreId);
					if(refStore != null &&  refStore.getPotential().compareTo(BigDecimal.ZERO) > 0) {
						s.setPotential(refStore.getPotential());
					} else {
						s.setPotential(averagePotential);
					}
				}else {
					s.setPotential(averagePotential);
				}
			}
		}
		
	}
	
	public List<StoreDemand> calculateStoreDemand(
			List<Store> storesA55,
			List<Store> storesA77,
			Map<Integer, BigDecimal> refWeights,
			Map<Integer, BigDecimal> trendFactors){
		
		List<StoreDemand> results = new ArrayList<>();
		
		BigDecimal weightA55 = refWeights.get(55);
		BigDecimal weightA77 = refWeights.get(77);
		BigDecimal totalWeight = weightA55.add(weightA77);
		
		for(Store sA55 : storesA55) {
			Integer storeId = sA55.getId();
			Store sA77 = findStoreById(storesA77, storeId);
			
			if(sA77 != null) {
				BigDecimal pA55 = sA55.getPotential();
				BigDecimal pA77 = sA77.getPotential();
				
				BigDecimal trend = trendFactors.getOrDefault(storeId, BigDecimal.ONE);
				
				BigDecimal sumWeightedPotential = pA55.multiply(weightA55).add(pA77.multiply(weightA77));
				
				BigDecimal baseDemand = sumWeightedPotential.divide(totalWeight, 4, RoundingMode.HALF_UP);
				
				BigDecimal finalDemand = baseDemand.multiply(trend).setScale(1, RoundingMode.HALF_UP);
				
				results.add(new StoreDemand(storeId, sA55.getWhId(), finalDemand));
			}
		}
		return results;
	}
	
	public List<whAllocation> sumUpdemandToWhLevel(List<StoreDemand> storeDemands){
		Map<Integer, BigDecimal> whMap = new java.util.HashMap<>();
		
		for(StoreDemand d : storeDemands) {
			Integer whId = d.getWhId();
			BigDecimal currentTotal = whMap.getOrDefault(whId, BigDecimal.ZERO);
			whMap.put(whId, currentTotal.add(d.getDemand()));
		}
		
		List<whAllocation> results = new ArrayList<>();
		for(Map.Entry<Integer, BigDecimal> entry : whMap.entrySet()) {
			whAllocation wh = new whAllocation(entry.getKey());
			wh.setTotalDemand(entry.getValue());
			results.add(wh);
		}
		return results;
	}
	
	public void calculateSharesAndAllocate(List<whAllocation> whAllocations, int planningAmount) {
		BigDecimal totalCountryDemand = BigDecimal.ZERO;
		for(whAllocation wh : whAllocations) {
			totalCountryDemand = totalCountryDemand.add(wh.getTotalDemand());
		}
		
		BigDecimal bdPlanningAmount = new BigDecimal(planningAmount);
		
		for(whAllocation wh : whAllocations) {
			if(totalCountryDemand.compareTo(BigDecimal.ZERO) > 0) {
				BigDecimal share = wh.getTotalDemand()
							.divide(totalCountryDemand, 10, RoundingMode.HALF_UP)
							.multiply(new BigDecimal("100"));
				wh.setShare(share);
				
				BigDecimal allocation = share
							.divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP)
							.multiply(bdPlanningAmount);
				wh.setAllocationAmount(allocation);
			}
		}
	}
	
	private Store findStoreById(List<Store> stores, Integer id) {
		for( Store s : stores) {
			if (s.getId().equals(id)) {
				return s;
			}
		}
		return null;
	}
	
}
