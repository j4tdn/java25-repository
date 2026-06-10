package utils;

import java.math.BigDecimal;
import java.util.Optional;

public class NumberUtils {

	private NumberUtils() {

	}
	
	public static boolean isNullOrZero(BigDecimal value) {
		return value == null || value.compareTo(BigDecimal.ZERO) == 0;
	}

	public static BigDecimal bd(double val) {
		return new BigDecimal(String.valueOf(val));
	}
	
	public static BigDecimal oneIfNull(BigDecimal value) {
		return Optional.ofNullable(value).orElse(BigDecimal.ONE);
	}

}