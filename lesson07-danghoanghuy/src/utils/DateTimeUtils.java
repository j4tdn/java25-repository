package utils;

public class DateTimeUtils {

	public DateTimeUtils() {
	}
	
	public static String getUnitValue(long value, String unit) {
		if (value != 0) {
			return value + " " + unit + " "; 
		}
		return "";
	}
	
}
