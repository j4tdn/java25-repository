package bean;

import java.math.BigDecimal;

public class StoreDemand {
	
	private Integer storeId;
	private Integer whId;
	private BigDecimal demand;
	
	public StoreDemand(Integer storeId, Integer whId, BigDecimal demand) {
		this.storeId = storeId;
		this.whId = whId;
		this.demand = demand;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public Integer getWhId() {
		return whId;
	}

	public BigDecimal getDemand() {
		return demand;
	}

	@Override
	public String toString() {
		return "StoreDemand [storeId=" + storeId + ", whId=" + whId + ", demand=" + demand + "]";
	}
}