package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {

	private NumberUtils() {

	}

	public static BigDecimal bd(double val) {
		return new BigDecimal(String.valueOf(val));
	}

	public static BigDecimal round1(BigDecimal val) {
		return val.setScale(1, RoundingMode.HALF_UP);
	}
	
	
	
	public static final BigDecimal ZERO = BigDecimal.ZERO;
	public static final BigDecimal ONE = BigDecimal.ONE;
	public static final BigDecimal HUNDRED = new BigDecimal("100");
}