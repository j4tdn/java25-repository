package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.DemandResult;
import bean.Store;
public class Step3 {

	
	public List<DemandResult> execute(List<Store> storesA55, List<Store> storesA77, Map<Integer, BigDecimal> trendFactors, Map<Integer, BigDecimal> refWeights  ){
		
		List<DemandResult> results = new ArrayList<>();
		
		BigDecimal weight55 = refWeights.get(55);
		BigDecimal weight77 = refWeights.get(77);
		BigDecimal totalweight = weight55.add(weight77);
		
		for(int i = 0 ; i< storesA55.size() ; i++) {
			Store store55 = storesA55.get(i);
			Store store77 = storesA77.get(i);
			BigDecimal potential77 = store77.getPotential();
			BigDecimal potential55 = store55.getPotential();
			BigDecimal demand = potential55.multiply(weight55).add(potential77.multiply(weight77)).divide(totalweight,1,RoundingMode.HALF_UP);
			BigDecimal trendFactor = trendFactors.getOrDefault(store55.getId(), BigDecimal.ONE );
			demand = demand.multiply(trendFactor);
			demand = demand.setScale(1, RoundingMode.HALF_UP);
			results.add(new DemandResult(store55, demand));
			
			
		}
		
		return results ;
		 
				 
	}
	
}
