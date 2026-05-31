package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.Item;
import bean.RefItemStoreId;
import bean.Store;

public class FillingGapsByReferencesOrAverageService {

	private final Map<Item, List<Store>> refItemStores;
	private final Map<Integer, Integer> refStores;
	
	public FillingGapsByReferencesOrAverageService(Map<Item, List<Store>> refItemStores,
			Map<Integer, Integer> refStores) {
		super();
		this.refItemStores = refItemStores;
		this.refStores = refStores;
	}
	
	private boolean isValidPotential(BigDecimal potential) {
		return potential != null  && potential.compareTo(BigDecimal.ZERO) > 0;
	}
	
	public Map<RefItemStoreId, BigDecimal> execute() {
		Map<RefItemStoreId, BigDecimal> reuslt = new HashMap<RefItemStoreId, BigDecimal>();
		this.refItemStores.forEach((item, stores) -> {
			Map<Integer, BigDecimal> storesHaveMaintainedPotential = stores.stream()
					.filter(store -> isValidPotential(store.getPotential()))
					.collect(Collectors.toMap(store -> store.getId(), store -> store.getPotential()));

			BigDecimal averagePotential = storesHaveMaintainedPotential.values().stream()
					.reduce(BigDecimal.ZERO, BigDecimal::add)
					.divide(BigDecimal.valueOf(storesHaveMaintainedPotential.size()), 1, RoundingMode.HALF_UP);
			for(Store store : stores) {
				Integer storeId = store.getId();
				BigDecimal currentPotential = store.getPotential();
				BigDecimal finalPotential = null;
				if(isValidPotential(currentPotential)) {
					finalPotential = currentPotential;
				} else {
					Integer refStoreId = this.refStores.get(storeId);
					if(isValidPotential(storesHaveMaintainedPotential.get(refStoreId))) {
						finalPotential = storesHaveMaintainedPotential.get(refStoreId);
					} else {
						finalPotential = averagePotential;
					}
				}
				reuslt.put(new RefItemStoreId(item.getId(), storeId), finalPotential);
			}
		});
		
		return reuslt;
	}
	
}
