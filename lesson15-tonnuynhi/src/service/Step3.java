package service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Store;
import model.DataModel;

public class Step3 {
	public Map<Integer, BigDecimal> execute(List<Store> listA55, List<Store> listA77) {
		System.out.println("/n=== Step 3: Caculate Store demand: ===");

		Map<Integer, BigDecimal> demandMap = new HashMap<>();

		Map<Integer, BigDecimal> refWeights = DataModel.mockRefWeights();
		Map<Integer, BigDecimal> trendFactors = DataModel.mockStoreTrendFactors();

		BigDecimal weightA55 = BigDecimal.ZERO;
		BigDecimal weightA77 = BigDecimal.ZERO;

		if (refWeights != null) {
			for (Map.Entry<Integer, BigDecimal> entry : refWeights.entrySet()) {

				if (entry.getKey().equals(55)) {
					weightA55 = entry.getValue();
				}
				if (entry.getKey().equals(77)) {
					weightA77 = entry.getValue();

				}
			}
		}

		BigDecimal totalWeight = weightA55.add(weightA77);
		System.out.println("Trong so 55 : " + weightA55);
		System.out.println("Trong so 77 : " + weightA77);
		System.out.println("Trong so tong : " + totalWeight);

		for (int i = 0; i < listA55.size(); i++) {
			Store storeA55 = listA55.get(i);
			Integer storeId = storeA55.getId();

			// A77
			Store storeA77 = null;
			for (int j = 0; j < listA77.size(); j++) {
				if (listA77.get(j).getId().equals(storeId)) {
					storeA77 = listA77.get(j);
					break;
				}
			}
			BigDecimal potentialA55 = storeA55.getPotential() != null ? storeA55.getPotential() : BigDecimal.ZERO;
			BigDecimal potentialA77 = (storeA77 != null && storeA77.getPotential() != null )? storeA77.getPotential()
					: BigDecimal.ZERO;

			BigDecimal tuSo = (potentialA55.multiply(weightA55)).add(potentialA77).multiply(weightA77);

			BigDecimal averageWeighted = BigDecimal.ZERO;
			if(totalWeight.compareTo(BigDecimal.ZERO)>=0) {
				averageWeighted = tuSo.divide(totalWeight, 4, java.math.RoundingMode.HALF_UP);
			}else {
				averageWeighted = BigDecimal.ZERO;
			}
			

			BigDecimal trend = BigDecimal.ONE;
			if (trendFactors != null && trendFactors.get(storeId) != null) {
				trend = trendFactors.get(storeId);
			}

			BigDecimal finalDemand = averageWeighted.multiply(trend);
			demandMap.put(storeId, finalDemand);
			System.out.println("=>Store " + storeId + "Final Demand =   " + finalDemand);

		}

		return demandMap;
	}

}
