package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Step6 {

    public Map<Integer, BigDecimal> execute(
            Map<Integer, BigDecimal> whShare,
            BigDecimal planningAmount
    ) {

        Map<Integer, BigDecimal> result = new HashMap<>();

        for (Map.Entry<Integer, BigDecimal> entry : whShare.entrySet()) {

            Integer whId = entry.getKey();
            BigDecimal share = entry.getValue();

            BigDecimal allocation = share
                    .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)
                    .multiply(planningAmount)
                    .setScale(1, RoundingMode.HALF_UP);

            result.put(whId, allocation);
        }

        return result;
    }
}