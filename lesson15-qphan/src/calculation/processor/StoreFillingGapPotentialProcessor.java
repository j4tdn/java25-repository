package calculation.processor;

import static utils.NumberUtils.bd;
import static utils.NumberUtils.isNullOrZero;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.Item;
import bean.Store;
import calculation.parameter.RefItemStoreId;

public class StoreFillingGapPotentialProcessor implements Processor<Map<RefItemStoreId, BigDecimal>> {

	private Map<Item, List<Store>> refItemStores;
	private Map<Long, Long> refStores;
	
	private StoreFillingGapPotentialProcessor(){
		
	}
	
	public static StoreFillingGapPotentialProcessor of() {
		return new StoreFillingGapPotentialProcessor();
	}
	
	public StoreFillingGapPotentialProcessor withReferenceItemStores(Map<Item, List<Store>> referenceItemStores) {
		this.refItemStores = referenceItemStores;
		return this;
	}
	
	public StoreFillingGapPotentialProcessor withReferenceStores(Map<Long, Long> referenceStores) {
		this.refStores = referenceStores;
		return this;
	}
	
	@Override
	public Map<RefItemStoreId, BigDecimal> process() {
		Map<RefItemStoreId, BigDecimal> result = new LinkedHashMap<>() ;
		refItemStores.forEach((refItem, stores) -> {
			Map<Long, BigDecimal> ownStorePotentials = stores.stream()
					.filter(store -> !isNullOrZero(store.getPotential()))
					.collect(Collectors.toMap(Store::getId, Store::getPotential));
			
			BigDecimal sumOfOwnStorePotential = ownStorePotentials.values()
					.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
					
			BigDecimal averageStorePotential = sumOfOwnStorePotential.divide(bd(ownStorePotentials.size()), 10, RoundingMode.HALF_UP);
			
			BigDecimal interpolatedStorePotential = null;
			for (Store store: stores) {
				Long storeId = store.getId();
				BigDecimal storePotential = store.getPotential();
				if (isNullOrZero(storePotential)) {
					Long refStoreId = refStores.get(storeId);
					if (refStoreId == null) {
						interpolatedStorePotential = averageStorePotential;
					} else {
						BigDecimal refStorePotential = ownStorePotentials.get(refStoreId);
						interpolatedStorePotential = isNullOrZero(refStorePotential) ? averageStorePotential : refStorePotential;
					}
				} else {
					interpolatedStorePotential = storePotential;
				}
				result.put(new RefItemStoreId(refItem.getId(), storeId), interpolatedStorePotential.setScale(1, RoundingMode.HALF_UP));
			}
		});
		return result;
	}
	
	
	
}
