package model;

public class Store {

	private Long storeId;
	private Long referenceStoreId;

	private Integer stockPreviousDay;

	private Double expectedSales;

	private boolean selected;

	private Double expectedSalesFinal;

	// step 2
	private Double allocationKey;
//step 3
	private Integer allocatedAmount;

	public Store() {
	}

	public Store(Long storeId, Long referenceStoreId, Integer stockPreviousDay, Double expectedSales,
			boolean selected) {

		this.storeId = storeId;
		this.referenceStoreId = referenceStoreId;
		this.stockPreviousDay = stockPreviousDay;
		this.expectedSales = expectedSales;
		this.selected = selected;
	}

//2
	public Double getAllocationKey() {
		return allocationKey;
	}

//2
	public void setAllocationKey(Double allocationKey) {
		this.allocationKey = allocationKey;
	}

	public Integer getAllocatedAmount() {
		return allocatedAmount;
	}

	public void setAllocatedAmount(Integer allocatedAmount) {
		this.allocatedAmount = allocatedAmount;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getReferenceStoreId() {
		return referenceStoreId;
	}

	public void setReferenceStoreId(Long referenceStoreId) {
		this.referenceStoreId = referenceStoreId;
	}

	public Integer getStockPreviousDay() {
		return stockPreviousDay;
	}

	public void setStockPreviousDay(Integer stockPreviousDay) {
		this.stockPreviousDay = stockPreviousDay;
	}

	public Double getExpectedSales() {
		return expectedSales;
	}

	public void setExpectedSales(Double expectedSales) {
		this.expectedSales = expectedSales;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Double getExpectedSalesFinal() {
		return expectedSalesFinal;
	}

	public void setExpectedSalesFinal(Double expectedSalesFinal) {
		this.expectedSalesFinal = expectedSalesFinal;
	}

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", referenceStoreId=" + referenceStoreId + ", stockPreviousDay="
				+ stockPreviousDay + ", expectedSales=" + expectedSales + ", selected=" + selected
				+ ", expectedSalesFinal=" + expectedSalesFinal + ", allocationKey=" + allocationKey
				+ ", allocatedAmount=" + allocatedAmount + "]";
	}
}