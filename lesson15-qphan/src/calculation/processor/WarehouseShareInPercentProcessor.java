package calculation.processor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static utils.NumberUtils.*; 

public class WarehouseShareInPercentProcessor implements Processor<Map<Long, BigDecimal>> {

	private Map<Long, BigDecimal> whDemands;

	private WarehouseShareInPercentProcessor() {
	}

	public static WarehouseShareInPercentProcessor of() {
		return new WarehouseShareInPercentProcessor();
	}

	public WarehouseShareInPercentProcessor withWhDemands(Map<Long, BigDecimal> whDemands) {
		this.whDemands = whDemands;
		return this;
	}

	@Override
	public Map<Long, BigDecimal> process() {
		BigDecimal totalDemands = whDemands.values()
				.stream()
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return whDemands.entrySet()
				.stream()
				.collect(Collectors.toMap(
						Entry::getKey, 
						e -> e.getValue().multiply(bd(100)).divide(totalDemands, 2, RoundingMode.HALF_UP)));
	}

}
