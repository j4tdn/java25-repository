package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import bean.Store;

public class Step2 {

	public void execute(List<Store> stores , Map<Integer, Integer> refStores) {
		
		for(Store store : stores) {
			
			BigDecimal potential = store.getPotential();
			
			if(potential.compareTo(BigDecimal.ZERO)> 0) {
				continue;
				
			}
			
			Integer refStoreId = refStores.get(store.getId());
			
			if(refStoreId == null) {
				continue;
				
			}
			
			Store refStore = findStoreById(stores, refStoreId);
			
			if(refStore != null ) {
				store.setPotential(refStore.getPotential());
				
			}
			
			
		}
		
		
	}
	
	
	
	private Store findStoreById(List<Store> stores, Integer id) {
		
		for(Store store : stores) {
			if(store.getId().equals(id)) {
				
				return store;
			}
		}
		
		return null;
		
	}
	
	
}
