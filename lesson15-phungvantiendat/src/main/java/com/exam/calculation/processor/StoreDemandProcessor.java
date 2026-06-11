package com.exam.calculation.processor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static com.exam.utils.NumberUtils.*;

import com.exam.calculation.parameter.RefItemStoreId;

public class StoreDemandProcessor implements Processor<Map<Long, BigDecimal>> {

    private Map<Long,BigDecimal> refWeights;
    private Map<Long,BigDecimal> storeTrendFactors;
    private Map<RefItemStoreId, BigDecimal> refItemStorePotentials;
    private List<Long> storeIds;

    private StoreDemandProcessor() {

    }

    public static StoreDemandProcessor of() {
        return new StoreDemandProcessor();
    }

    public StoreDemandProcessor withRefItemStorePotentials(Map<RefItemStoreId, BigDecimal> refItemStorePotentials) {
        this.refItemStorePotentials = refItemStorePotentials;
        return this;
    }

    public StoreDemandProcessor withRefWeights(Map<Long, BigDecimal> refWeights) {
        this.refWeights = refWeights;
        return this;
    }

    public StoreDemandProcessor withStoreTrendFactors(Map<Long, BigDecimal> storeTrendFactors) {
        this.storeTrendFactors = storeTrendFactors;
        return this;
    }

    public StoreDemandProcessor withStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
        return this;
    }

    @Override
    public Map<Long, BigDecimal> process() {
        Map<Long, BigDecimal> result = new HashMap<>();

        Map<Long, List<Entry<RefItemStoreId, BigDecimal>>> storeRefItemPotentials  = refItemStorePotentials.entrySet()
            .stream()
            .collect(Collectors.groupingBy(e -> e.getKey().getStoreId()));

        storeIds.forEach(storeId -> {

            List<Entry<RefItemStoreId, BigDecimal>> refItemPotentials = storeRefItemPotentials.get(storeId);

            BigDecimal sumOfWeights = BigDecimal.ZERO;

            BigDecimal sumOfWeightPotentials = BigDecimal.ZERO;


            for(Entry<RefItemStoreId, BigDecimal> refItemStorePotential : refItemPotentials) {
                Long refItemId = refItemStorePotential.getKey().getRefItemId();
                BigDecimal refItemWeight = oneIfNull(refWeights.get(refItemId));
                BigDecimal refItemPotential = refItemStorePotential.getValue();

                sumOfWeights = sumOfWeights.add(refItemWeight);

                sumOfWeightPotentials = sumOfWeightPotentials.add(refItemPotential.multiply(refItemWeight));
            }

            BigDecimal storeTrendFactor = oneIfNull(storeTrendFactors.get(storeId));
            
            BigDecimal storeDemand = sumOfWeightPotentials.multiply(storeTrendFactor).divide(sumOfWeights,1, RoundingMode.HALF_UP);

            result.put(storeId, storeDemand);
        });

        return result;
    }
    
}
