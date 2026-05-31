package view;

import java.math.BigDecimal;

public class WhResult {

	private Integer whId;
	private int amountOfStores;
	private BigDecimal demand;
	private BigDecimal share;
	private BigDecimal allocation;
	private boolean minApplied;
	private BigDecimal allocationRounded;
	
	public WhResult(Integer whId) {
		this.whId = whId;
	}

	public WhResult(Integer whId, int amountOfStores, BigDecimal demand, BigDecimal share, BigDecimal allocation,
			boolean minApplied, BigDecimal allocationRounded) {
		this.whId = whId;
		this.amountOfStores = amountOfStores;
		this.demand = demand;
		this.share = share;
		this.allocation = allocation;
		this.minApplied = minApplied;
		this.allocationRounded = allocationRounded;
	}

	public Integer getWhId() {
		return whId;
	}

	public void setWhId(Integer whId) {
		this.whId = whId;
	}

	public int getAmountOfStores() {
		return amountOfStores;
	}

	public void setAmountOfStores(int amountOfStores) {
		this.amountOfStores = amountOfStores;
	}

	public BigDecimal getDemand() {
		return demand;
	}

	public void setDemand(BigDecimal demand) {
		this.demand = demand;
	}

	public BigDecimal getShare() {
		return share;
	}

	public void setShare(BigDecimal share) {
		this.share = share;
	}

	public BigDecimal getAllocation() {
		return allocation;
	}

	public void setAllocation(BigDecimal allocation) {
		this.allocation = allocation;
	}

	public boolean isMinApplied() {
		return minApplied;
	}

	public void setMinApplied(boolean minApplied) {
		this.minApplied = minApplied;
	}

	public BigDecimal getAllocationRounded() {
		return allocationRounded;
	}

	public void setAllocationRounded(BigDecimal allocationRounded) {
		this.allocationRounded = allocationRounded;
	}

	@Override
	public String toString() {
		return "WhResult [whId=" + whId + ", amountOfStores=" + amountOfStores + ", demand=" + demand + ", share="
				+ share + ", allocation=" + allocation + ", minApplied=" + minApplied + ", allocationRounded="
				+ allocationRounded + "]";
	}
	
	
}
