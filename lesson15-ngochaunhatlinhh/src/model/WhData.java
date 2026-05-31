package model;

import java.math.BigDecimal;

public class WhData {
	public Integer whId;
	public int storeCount;
	public final BigDecimal demand;
	public BigDecimal share;
	public BigDecimal allocation;
	public boolean hasMin;
	public BigDecimal recalculatedShare;
	public BigDecimal newAllocation;
	public BigDecimal roundedAllocation;

	public WhData(Integer whId, int storeCount, BigDecimal demand) {
		this.whId = whId;
		this.storeCount = storeCount;
		this.demand = demand;
	}
}
