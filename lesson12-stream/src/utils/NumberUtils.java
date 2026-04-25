package utils;

import java.math.BigDecimal;

public class NumberUtils {
	
	private NumberUtils() {
	}
	
	public static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
	public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}