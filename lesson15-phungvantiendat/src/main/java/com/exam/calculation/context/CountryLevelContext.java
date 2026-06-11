package com.exam.calculation.context;

import com.exam.bean.Item;
import com.exam.bean.Store;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CountryLevelContext extends Context {

  private Integer planningAmount;
  private Integer requiredMinPlanningAmount;

  private Map<Item, List<Store>> referenceItemStores;
  private Map<Long, Long> referenceStores;

  private Map<Long, BigDecimal> refWeights;

  private Map<Long, BigDecimal> storeTrendFactors;

  private List<Long> storeIds;

  private CountryLevelContext() {}

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

  public Map<Item, List<Store>> getReferenceItemStores() {
    return referenceItemStores;
  }

  public CountryLevelContext withReferenceItemStores(Map<Item, List<Store>> referenceItemStores) {
    this.referenceItemStores = referenceItemStores;
    return this;
  }

  public Map<Long, Long> getReferenceStores() {
    return referenceStores;
  }

  public Map<Long, BigDecimal> getRefWeights() {
    return refWeights;
  }

  public Map<Long, BigDecimal> getStoreTrendFactors() {
    return storeTrendFactors;
  }

  public List<Long> getStoreIds() {
    return storeIds;
  }

  public CountryLevelContext withReferenceStores(Map<Long, Long> referenceStores) {
    this.referenceStores = referenceStores;
    return this;
  }

  public CountryLevelContext withStoreTrendFactors(Map<Long, BigDecimal> storeTrendFactors) {
    this.storeTrendFactors = storeTrendFactors;
    return this;
  }

  public CountryLevelContext withRefWeights(Map<Long, BigDecimal> refWeights) {
    this.refWeights = refWeights;
    return this;
  }

  public CountryLevelContext withStoreIds(List<Long> storeIds) {
    this.storeIds = storeIds;
    return this;
  }
}
