package calculation.processor;

import static utils.NumberUtils.bd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class WarehouseRecalculateShareProcessor implements Processor<Map<Long, BigDecimal>> {

	private Map<Long, BigDecimal> whAllocatedAmounts;
	private Map<Long, Integer> whAppliedMins;

	private WarehouseRecalculateShareProcessor() {
	}

	public static WarehouseRecalculateShareProcessor of() {
		return new WarehouseRecalculateShareProcessor();
	}

	public WarehouseRecalculateShareProcessor withWhAllocatedAmounts(Map<Long, BigDecimal> whAllocatedAmounts) {
		this.whAllocatedAmounts = whAllocatedAmounts;
		return this;
	}

	public WarehouseRecalculateShareProcessor withWhAppliedMins(Map<Long, Integer> whAppliedMins) {
		this.whAppliedMins = whAppliedMins;
		return this;
	}

	@Override
	public Map<Long, BigDecimal> process() {
		Map<Long, BigDecimal> whAllocatedAmountsNoApplyMin = whAllocatedAmounts.entrySet()
				.stream()
				.filter(e -> whAppliedMins.get(e.getKey()) == null)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
		
		BigDecimal totalAmountNoApplyMin = whAllocatedAmountsNoApplyMin.values()
				.stream()
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return whAllocatedAmountsNoApplyMin.entrySet()
				.stream()
				.collect(Collectors.toMap(
						Entry::getKey, 
						e -> e.getValue().multiply(bd(100)).divide(totalAmountNoApplyMin, 2, RoundingMode.HALF_UP)));
				
	}

}
