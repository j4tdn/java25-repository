package calculation.processor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static utils.NumberUtils.*; 

public class WarehouseAllocateByShareProcessor implements Processor<Map<Long, BigDecimal>> {

	private Integer planningAmount;
	private Map<Long, BigDecimal> whShares;
	

	private WarehouseAllocateByShareProcessor() {
	}

	public static WarehouseAllocateByShareProcessor of() {
		return new WarehouseAllocateByShareProcessor();
	}
	
	public WarehouseAllocateByShareProcessor withPlanningAmount(Integer planningAmount) {
		this.planningAmount = planningAmount;
		return this;
	}

	public WarehouseAllocateByShareProcessor withWhShares(Map<Long, BigDecimal> whShares) {
		this.whShares = whShares;
		return this;
	}

	@Override
	public Map<Long, BigDecimal> process() {
		return whShares.entrySet()
				.stream()
				.collect(Collectors.toMap(
						Entry::getKey, 
						e -> e.getValue().multiply(bd(planningAmount)).divide(bd(100), 10, RoundingMode.HALF_UP)));
	}

}
