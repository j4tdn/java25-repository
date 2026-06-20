package calculation.processor;

import static utils.NumberUtils.bd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class WarehouseReallocateProcessor implements Processor<Map<Long, BigDecimal>> {

	private Integer planningAmount;
	private Map<Long, BigDecimal> whAllocatedAmounts;
	private Map<Long, Integer> whAppliedMins;
	private Map<Long, BigDecimal> whRecalculatedShares;

	private WarehouseReallocateProcessor() {
	}

	public static WarehouseReallocateProcessor of() {
		return new WarehouseReallocateProcessor();
	}

	public WarehouseReallocateProcessor withPlanningAmount(Integer planningAmount) {
		this.planningAmount = planningAmount;
		return this;
	}
	
	public WarehouseReallocateProcessor withWhAllocatedAmounts(Map<Long, BigDecimal> whAllocatedAmounts) {
		this.whAllocatedAmounts = whAllocatedAmounts;
		return this;
	}

	public WarehouseReallocateProcessor withWhAppliedMins(Map<Long, Integer> whAppliedMins) {
		this.whAppliedMins = whAppliedMins;
		return this;
	}
	
	public WarehouseReallocateProcessor withWhRecalculatedShares(Map<Long, BigDecimal> whRecalculatedShares) {
		this.whRecalculatedShares = whRecalculatedShares;
		return this;
	}

	@Override
	public Map<Long, BigDecimal> process() {
		Integer totalWhAmountAppliedMin = whAppliedMins.values()
				.stream()
				.reduce(0, Integer::sum);
		
		Integer newPlanningAmount = planningAmount - totalWhAmountAppliedMin;
		
		return whAllocatedAmounts.entrySet()
				.stream()
				.collect(Collectors.toMap(
						Entry::getKey,
						e -> {
							Long whId = e.getKey();
							final Integer whAppliedMin = whAppliedMins.get(whId);
							if (whAppliedMin != null) {
								return bd(whAppliedMin);
							}
							return whRecalculatedShares.get(whId)
									.multiply(bd(newPlanningAmount))
									.divide(bd(100), 10, RoundingMode.HALF_UP);
						}));
				
	}

}
