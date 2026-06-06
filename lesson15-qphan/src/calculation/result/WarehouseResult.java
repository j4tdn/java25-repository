package calculation.result;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class WarehouseResult {
	
	// Quy ước
	// ID: Long
	// Value: Integer, BigDecimal
	
	private Map<Long, BigDecimal> whDemands = new LinkedHashMap<>();
	private Map<Long, Integer> whAllocatedAmounts = new LinkedHashMap<>();
	
	public Map<Long, BigDecimal> getWhDemands() {
		return whDemands;
	}
	
	public void setWhDemands(Map<Long, BigDecimal> whDemands) {
		this.whDemands = whDemands;
	}
	
	public Map<Long, Integer> getWhAllocatedAmounts() {
		return whAllocatedAmounts;
	}
	
	public void setWhAllocatedAmounts(Map<Long, Integer> whAllocatedAmounts) {
		this.whAllocatedAmounts = whAllocatedAmounts;
	}
	
}
