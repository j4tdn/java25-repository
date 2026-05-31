package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingUtils {
	public static double round(double value, int scale) {
		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(scale, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

}
