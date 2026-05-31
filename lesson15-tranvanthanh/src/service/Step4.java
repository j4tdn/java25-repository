package service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.DemandResult;
import bean.Store;

public class Step4 {

    public Map<Integer, BigDecimal> execute(List<DemandResult> demandResults) {

        Map<Integer, BigDecimal> whDemand = new HashMap<>();

        for (DemandResult dr : demandResults) {

            Store store = dr.getStore();
            Integer storeId = store.getId();

            Integer whId = getWarehouse(storeId);

            BigDecimal demand = dr.getDemand();

            whDemand.put(
                whId,
                whDemand.getOrDefault(whId, BigDecimal.ZERO).add(demand)
            );
        }

        return whDemand;
    }

    private Integer getWarehouse(Integer storeId) {

        if (storeId >= 2 && storeId <= 6) {
            return 1; 
        }

        if (storeId == 1 || (storeId >= 7 && storeId <= 10)) {
            return 2; 
        }

        return 3; 
    }
}