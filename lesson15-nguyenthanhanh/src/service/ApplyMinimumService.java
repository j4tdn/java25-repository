package service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ApplyMinimumService {

	private final Map<Integer, BigDecimal> whAllocationAmounts;
	private final Integer minPerStore;
	private final Map<Integer, Integer> storeWhIds;
	
	public ApplyMinimumService(Map<Integer, BigDecimal> whAllocationAmounts, Integer minPerStore,
			Map<Integer, Integer> storeWhIds) {
		super();
		this.whAllocationAmounts = whAllocationAmounts;
		this.minPerStore = minPerStore;
		this.storeWhIds = storeWhIds;
	}
	
	public Map<Integer, BigDecimal> execute() {
		Map<Integer, Long> countStoresPerWh = this.storeWhIds.entrySet().stream()
				.collect(Collectors.groupingBy(
						entry -> entry.getValue(),
						Collectors.counting()));
		
		Map<Integer, BigDecimal> finallAllocationAmounts = new HashMap<Integer, BigDecimal>();
		BigDecimal minPerStoreBd = BigDecimal.valueOf(this.minPerStore);
		
		this.whAllocationAmounts.forEach((whId, allocationAmount) -> {
			Long numberOfStores = countStoresPerWh.get(whId);
			
			BigDecimal minRequiedForWh = minPerStoreBd
					.multiply(BigDecimal.valueOf(numberOfStores));
			
			if(allocationAmount.compareTo(minRequiedForWh) < 0) {
				finallAllocationAmounts.put(whId, minRequiedForWh);
			} else {
				finallAllocationAmounts.put(whId, allocationAmount);
			}
			
		});
		
		return finallAllocationAmounts;
	}
	
}
