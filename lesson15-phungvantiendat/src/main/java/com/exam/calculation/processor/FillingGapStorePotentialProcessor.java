package com.exam.calculation.processor;

import static com.exam.utils.NumberUtils.*;

import com.exam.bean.Item;
import com.exam.bean.Store;
import com.exam.calculation.parameter.RefItemStoreId;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FillingGapStorePotentialProcessor
    implements Processor<Map<RefItemStoreId, BigDecimal>> {

  private Map<Item, List<Store>> referenceItemStores;
  private Map<Long, Long> referenceStores;

  private FillingGapStorePotentialProcessor() {}

  public static FillingGapStorePotentialProcessor of() {
    return new FillingGapStorePotentialProcessor();
  }

  public FillingGapStorePotentialProcessor withReferenceItemStores(
      Map<Item, List<Store>> referenceItemStores) {
    this.referenceItemStores = referenceItemStores;
    return this;
  }

  public FillingGapStorePotentialProcessor withReferenceStores(Map<Long, Long> referenceStores) {
    this.referenceStores = referenceStores;
    return this;
  }

  @Override
  public Map<RefItemStoreId, BigDecimal> process() {
    Map<RefItemStoreId, BigDecimal> result = new HashMap<>();
    referenceItemStores.forEach(
        (refItem, stores) -> {
          Map<Long, BigDecimal> ownStorePotentitals =
              stores.stream()
                  .filter(store -> !isNullOrZero(store.getPotential()))
                  .collect(Collectors.toMap(Store::getId, Store::getPotential));

          BigDecimal sumOfOwnStorePotential =
              ownStorePotentitals.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);

          BigDecimal averageStorePotential =
              sumOfOwnStorePotential.divide(
                  bd(ownStorePotentitals.size()), 1, RoundingMode.HALF_UP);

          BigDecimal interpolatedStorePotential = null;

          for (Store store : stores) {
            Long storeId = store.getId();
            BigDecimal storePotential = store.getPotential();
            if (isNullOrZero(storePotential)) {
              Long refStoreId = referenceStores.get(storeId);
              if (refStoreId == null) {
                interpolatedStorePotential = averageStorePotential;
              } else {
                BigDecimal refStorePotential = ownStorePotentitals.get(refStoreId);
                interpolatedStorePotential =
                    isNullOrZero(refStorePotential) ? averageStorePotential : refStorePotential;
              }
            } else {
              interpolatedStorePotential = storePotential;
            }

            result.put(
                new RefItemStoreId(refItem.getId(), storeId),
                interpolatedStorePotential.setScale(1, RoundingMode.HALF_UP));
          }
        });
    return result;
  }
}
