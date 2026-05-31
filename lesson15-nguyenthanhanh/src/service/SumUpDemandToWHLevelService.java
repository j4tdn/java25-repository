package service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public class SumUpDemandToWHLevelService {

	private final Map<Integer, BigDecimal> storeDemands;
	private final Map<Integer, Integer> storeWhIds;
	
	public SumUpDemandToWHLevelService(Map<Integer, BigDecimal> storeDemands, Map<Integer, Integer> storeWhIds) {
		super();
		this.storeDemands = storeDemands;
		this.storeWhIds = storeWhIds;
	}
	
	public Map<Integer, BigDecimal> execute() {
		Map<Integer, BigDecimal> whDemands = this.storeDemands.entrySet().stream()
				.collect(Collectors.groupingBy(
						entry -> this.storeWhIds.get(entry.getKey()),
						Collectors.reducing(
								BigDecimal.ZERO,
								entry -> entry.getValue(),
								(total, current) -> total.add(current))));
		return whDemands;
	}
	
}
