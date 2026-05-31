package bean;

import java.math.BigDecimal;

public class whAllocation {
	private Integer whId;
	private BigDecimal totalDemand;
	private BigDecimal share;
	private BigDecimal allocationAmount;
	
	public whAllocation(Integer whId) {
		this.whId = whId;
		this.totalDemand = BigDecimal.ZERO;
		this.share = BigDecimal.ZERO;
		this.allocationAmount = BigDecimal.ZERO;
	}
	
	public Integer getWhId() {
		return whId;
	}
	
	public void setWhId(Integer whId) {
		this.whId = whId;
	}
	
	public BigDecimal getTotalDemand() {
		return totalDemand;
	}

	public BigDecimal getShare() {
		return share;
	}

	public void setShare(BigDecimal share) {
		this.share = share;
	}

	public BigDecimal getAllocationAmount() {
		return allocationAmount;
	}

	public void setAllocationAmount(BigDecimal allocationAmount) {
		this.allocationAmount = allocationAmount;
	}

	public void setTotalDemand(BigDecimal totalDemand) {
		this.totalDemand = totalDemand;
	}

	@Override
	public String toString() {
		return "whAllocation [whId=" + whId + ", totalDemand=" + totalDemand + ", share=" + share
				+ ", allocationAmount=" + allocationAmount + "]";
	}
	
	

}
