package calculation.processor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors; 

public class WarehouseRoundUpAmountProcessor implements Processor<Map<Long, Integer>> {

	private Map<Long, BigDecimal> whAllocatedAmounts;

	private WarehouseRoundUpAmountProcessor() {
	}

	public static WarehouseRoundUpAmountProcessor of() {
		return new WarehouseRoundUpAmountProcessor();
	}

	public WarehouseRoundUpAmountProcessor withWhAllocatedAmounts(Map<Long, BigDecimal> whAllocatedAmounts) {
		this.whAllocatedAmounts = whAllocatedAmounts;
		return this;
	}

	@Override
	public Map<Long, Integer> process() {
		return whAllocatedAmounts.entrySet()
				.stream()
				.collect(Collectors.toMap(
						Entry::getKey, 
						e -> e.getValue().setScale(0, RoundingMode.UP).intValue()));
	}

}
