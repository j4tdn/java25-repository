package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class AllocateBySharesService {

	private final Map<Integer, BigDecimal> whShares;
	private final Integer planningAmount;
	
	public AllocateBySharesService(Map<Integer, BigDecimal> whShares, Integer planningAmount) {
		super();
		this.whShares = whShares;
		this.planningAmount = planningAmount;
	}
	
	public Map<Integer, BigDecimal> execute() {
		Map<Integer, BigDecimal> whAllocationAmounts = new HashMap<Integer, BigDecimal>();
		BigDecimal totalAmountBd = BigDecimal.valueOf(this.planningAmount);
		
		this.whShares.forEach((whId, shares) -> {
			BigDecimal allocationAmount = shares
					.divide(BigDecimal.valueOf(100), 1, RoundingMode.HALF_UP)
					.multiply(totalAmountBd);
			
			whAllocationAmounts.put(whId, allocationAmount);
		});
		
		return whAllocationAmounts;
	}
	
}
