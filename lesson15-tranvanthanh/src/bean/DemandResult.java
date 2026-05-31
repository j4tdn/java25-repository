package bean;

import java.math.BigDecimal;

public class DemandResult {

	private Store store;
	private BigDecimal demand;
	
	

	public DemandResult(Store store, BigDecimal demand) {
		this.store = store;
		this.demand = demand;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public BigDecimal getDemand() {
		return demand;
	}

	public void setDemand(BigDecimal demand) {
		this.demand = demand;
	}

	@Override
	public String toString() {
		return store.getDesc()+ " -> "+ demand;
		
	}
	
	
	
	
	
	
}
