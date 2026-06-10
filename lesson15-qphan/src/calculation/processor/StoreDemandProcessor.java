package calculation.processor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static utils.NumberUtils.*;

import calculation.parameter.RefItemStoreId;

public class StoreDemandProcessor implements Processor<Map<Long, BigDecimal>> {

	private Map<RefItemStoreId, BigDecimal> refItemStorePotentials;
	private Map<Long, BigDecimal> refWeights;
	private Map<Long, BigDecimal> storeTrendFactors;
	private List<Long> storeIds;

	private StoreDemandProcessor() {
	}

	public static StoreDemandProcessor of() {
		return new StoreDemandProcessor();
	}

	public StoreDemandProcessor withRefItemStorePotentials(Map<RefItemStoreId, BigDecimal> refItemStorePotentials) {
		this.refItemStorePotentials = refItemStorePotentials;
		return this;
	}

	public StoreDemandProcessor withRefWeights(Map<Long, BigDecimal> refWeights) {
		this.refWeights = refWeights;
		return this;
	}

	public StoreDemandProcessor withStoreTrendFactors(Map<Long, BigDecimal> storeTrendFactors) {
		this.storeTrendFactors = storeTrendFactors;
		return this;
	}

	public StoreDemandProcessor withStoreIds(List<Long> storeIds) {
		this.storeIds = storeIds;
		return this;
	}

	@Override
	public Map<Long, BigDecimal> process() {
		Map<Long, BigDecimal> result = new HashMap<>();
		
		Map<Long, List<Entry<RefItemStoreId, BigDecimal>>> storeRefItemPotentials = refItemStorePotentials.entrySet() // Set<Entry<RefItemStoreId, BigDecimal>>
			.stream() // Stream<Entry<RefItemStoreId, BigDecimal>>
			.collect(Collectors.groupingBy(e -> e.getKey().getStoreId()));
		
		storeIds.forEach(storeId -> {
			List<Entry<RefItemStoreId, BigDecimal>> refItemPotentials = storeRefItemPotentials.get(storeId);
			
			BigDecimal sumOfWeightPotential = BigDecimal.ZERO; // tử số
			BigDecimal sumOfWeight = BigDecimal.ZERO; // mẫu số
			
			for (Entry<RefItemStoreId, BigDecimal> refItemStorePotential: refItemPotentials) {
				Long refItemId = refItemStorePotential.getKey().getRefItemId();
				BigDecimal refItemPotential = refItemStorePotential.getValue();
				BigDecimal refItemWeight = oneIfNull(refWeights.get(refItemId));
				
				sumOfWeightPotential = sumOfWeightPotential.add(refItemPotential.multiply(refItemWeight));
				sumOfWeight = sumOfWeight.add(refItemWeight);
			}
			
			BigDecimal storeTrendFactor = oneIfNull(storeTrendFactors.get(storeId));
			BigDecimal storeDemand = sumOfWeightPotential.multiply(storeTrendFactor).divide(sumOfWeight, 1, RoundingMode.HALF_UP);
			result.put(storeId, storeDemand);
		});
		return result;
	}
	
}
