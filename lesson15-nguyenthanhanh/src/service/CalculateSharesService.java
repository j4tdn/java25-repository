package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CalculateSharesService {

	private final Map<Integer, BigDecimal> whDemands;

	public CalculateSharesService(Map<Integer, BigDecimal> whDemands) {
		super();
		this.whDemands = whDemands;
	}
	
	public Map<Integer, BigDecimal> execute() {
		BigDecimal totalAllCountryDemand = this.whDemands.values().stream()
				.reduce(BigDecimal.ZERO, (total, current) -> total.add(current));
		
		Map<Integer, BigDecimal> whShares = new HashMap<Integer, BigDecimal>();
		this.whDemands.forEach((whId, demand) -> {
			BigDecimal shares = demand.divide(totalAllCountryDemand, 3, RoundingMode.HALF_UP)
					.multiply(BigDecimal.valueOf(100));
			
			whShares.put(whId, shares);
		});
		
		return whShares;
	}
	
}
