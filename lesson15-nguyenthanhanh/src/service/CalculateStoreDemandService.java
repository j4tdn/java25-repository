package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.RefItemStoreId;

public class CalculateStoreDemandService {

	private final List<Map<RefItemStoreId, BigDecimal>> allItemStorePotentials;
	private final Map<Integer, BigDecimal>  refWeights;
	private final Map<Integer, BigDecimal> refStoreTrendFactors;
	private final List<Integer> itemStoreIds;
	
	public CalculateStoreDemandService(List<Map<RefItemStoreId, BigDecimal>> allItemStorePotentials,
			Map<Integer, BigDecimal> refWeights, Map<Integer, BigDecimal> refStoreTrendFactors,
			List<Integer> itemStoreIds) {
		super();
		this.allItemStorePotentials = allItemStorePotentials;
		this.refWeights = refWeights;
		this.refStoreTrendFactors = refStoreTrendFactors;
		this.itemStoreIds = itemStoreIds;
	}
	
	public Map<Integer, BigDecimal> execute() {
		Map<Integer, BigDecimal> storeDemands = new HashMap<Integer, BigDecimal>();
		for(Integer storeId : this.itemStoreIds) {
			BigDecimal numerator = BigDecimal.ZERO;
			BigDecimal denominator = BigDecimal.ZERO;
			for(Map.Entry<Integer, BigDecimal> weightEntry : this.refWeights.entrySet()) {
				Integer refItemId = weightEntry.getKey();
				BigDecimal weight = weightEntry.getValue();
				
				RefItemStoreId refItemStoreId = new RefItemStoreId(refItemId, storeId);
				BigDecimal potential = null;
				
				for(Map<RefItemStoreId, BigDecimal> itemStorePotentials : this.allItemStorePotentials) {
					if(itemStorePotentials.containsKey(refItemStoreId)) {
						potential = itemStorePotentials.get(refItemStoreId);
						break;
					}
				}
				
				if(potential != null) {
					numerator = numerator.add(potential.multiply(weight));
					denominator = denominator.add(weight);
				}
			}
			
			BigDecimal trend = this.refStoreTrendFactors.getOrDefault(storeId, BigDecimal.ONE);
			
			BigDecimal finalDemand = numerator.divide(denominator, 1, RoundingMode.HALF_UP)
					.multiply(trend);
			
			storeDemands.put(storeId, finalDemand);
		}
		
		return storeDemands;
	}
	
}
