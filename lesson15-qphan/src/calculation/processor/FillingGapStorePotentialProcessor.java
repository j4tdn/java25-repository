package calculation.processor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import bean.Item;
import bean.Store;
import calculation.parameter.RefItemStoreId;

public class FillingGapStorePotentialProcessor implements Processor<Map<RefItemStoreId, BigDecimal>> {

	private Map<Item, List<Store>> referenceItemStores;
	private Map<Long, Long> referenceStores;
	
	public static FillingGapStorePotentialProcessor of() {
		return new FillingGapStorePotentialProcessor();
	}
	
	public FillingGapStorePotentialProcessor withReferenceItemStores(Map<Item, List<Store>> referenceItemStores) {
		this.referenceItemStores = referenceItemStores;
		return this;
	}
	
	public FillingGapStorePotentialProcessor withReferenceStores(Map<Long, Long> referenceStores) {
		this.referenceStores = referenceStores;
		return this;
	}
	
	@Override
	public Map<RefItemStoreId, BigDecimal> process() {
		// logic
		return null;
	}
	
	
	
}
