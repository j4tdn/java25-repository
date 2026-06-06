package calculation.context;

import java.util.List;
import java.util.Map;

import bean.Item;
import bean.Store;

public class CountryLevelContext extends Context {
	
	private Integer planningAmount;
	private Integer requiredMinPlanningAmount;
	
	private Map<Item, List<Store>> referenceItemStores;
	private Map<Long, Long> referenceStores;
	
	private CountryLevelContext() {
	}
	
	public static CountryLevelContext of() {
		return new CountryLevelContext();
	}
	
	public Integer getPlanningAmount() {
		return planningAmount;
	}
	
	public CountryLevelContext setPlanningAmount(Integer planningAmount) {
		this.planningAmount = planningAmount;
		return this;
	}
	
	public Integer getRequiredMinPlanningAmount() {
		return requiredMinPlanningAmount;
	}
	
	public CountryLevelContext setRequiredMinPlanningAmount(Integer requiredMinPlanningAmount) {
		this.requiredMinPlanningAmount = requiredMinPlanningAmount;
		return this;
	}

	public Map<Item, List<Store>> getReferenceItemStores() {
		return referenceItemStores;
	}

	public CountryLevelContext setReferenceItemStores(Map<Item, List<Store>> referenceItemStores) {
		this.referenceItemStores = referenceItemStores;
		return this;
	}

	public Map<Long, Long> getReferenceStores() {
		return referenceStores;
	}

	public CountryLevelContext setReferenceStores(Map<Long, Long> referenceStores) {
		this.referenceStores = referenceStores;
		return this;
	}
	
}
