package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Step5 {

     public Map<Integer, BigDecimal> execute(Map<Integer, BigDecimal> whDemand) {

        Map<Integer, BigDecimal> result = new HashMap<>();

        BigDecimal total = BigDecimal.ZERO;

        for (BigDecimal value : whDemand.values()) {
            total = total.add(value);
        }

        if (total.compareTo(BigDecimal.ZERO) == 0) {
            return result;
        }

        for (Map.Entry<Integer, BigDecimal> entry : whDemand.entrySet()) {

            BigDecimal share = entry.getValue()
                    .multiply(BigDecimal.valueOf(100))
                    .divide(total, 2, RoundingMode.HALF_UP);

            result.put(entry.getKey(), share);
        }

        return result;
    }
}