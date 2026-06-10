package calculation.context;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import bean.Item;
import bean.Store;

public class CountryLevelContext extends Context {
	
	private Integer planningAmount;
	private Integer requiredMinPlanningAmount;
	private Map<Item, List<Store>> refItemStores;
	private Map<Long, Long> refStores;
	private Map<Long, BigDecimal> refWeights;
	private Map<Long, BigDecimal> storeTrendFactors;
	private List<Long> storeIds;
	
	private CountryLevelContext() {
	}
	
	public static CountryLevelContext of() {
		return new CountryLevelContext();
	}
	
	public Integer getPlanningAmount() {
		return planningAmount;
	}
	
	public CountryLevelContext withPlanningAmount(Integer planningAmount) {
		this.planningAmount = planningAmount;
		return this;
	}
	
	public Integer getRequiredMinPlanningAmount() {
		return requiredMinPlanningAmount;
	}
	
	public CountryLevelContext withRequiredMinPlanningAmount(Integer requiredMinPlanningAmount) {
		this.requiredMinPlanningAmount = requiredMinPlanningAmount;
		return this;
	}

	public Map<Item, List<Store>> getRefItemStores() {
		return refItemStores;
	}

	public CountryLevelContext withRefItemStores(Map<Item, List<Store>> refItemStores) {
		this.refItemStores = refItemStores;
		return this;
	}

	public Map<Long, Long> getRefStores() {
		return refStores;
	}

	public CountryLevelContext withRefStores(Map<Long, Long> refStores) {
		this.refStores = refStores;
		return this;
	}
	
	public Map<Long, BigDecimal> getRefWeights() {
		return refWeights;
	}
	
	public CountryLevelContext withRefWeights(Map<Long, BigDecimal> refWeights) {
		this.refWeights = refWeights;
		return this;
	}
	
	public Map<Long, BigDecimal> getStoreTrendFactors() {
		return storeTrendFactors;
	}
	
	public CountryLevelContext withStoreTrendFactors(Map<Long, BigDecimal> storeTrendFactors) {
		this.storeTrendFactors = storeTrendFactors;
		return this;
	}
	
	public List<Long> getStoreIds() {
		return storeIds;
	}
	
	public CountryLevelContext withStoreIds(List<Long> storeIds) {
		this.storeIds = storeIds;
		return this;
	}
}
