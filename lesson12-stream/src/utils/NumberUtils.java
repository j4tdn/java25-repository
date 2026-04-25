package utils;

import java.math.BigDecimal;

public class NumberUtils {

    private NumberUtils() {
    }

    public static BigDecimal bd(String value) {
        return new BigDecimal(value);
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}