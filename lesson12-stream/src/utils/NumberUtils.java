package utils;

import java.math.BigDecimal;

public class NumberUtils {

	private NumberUtils() {
	}
	
	public static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
}
