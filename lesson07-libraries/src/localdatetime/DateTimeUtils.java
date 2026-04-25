package localdatetime;

public class DateTimeUtils {
	
	public DateTimeUtils() {
	}
	
	public static String getUnitValue(int value, String unit) {
		if(value != 0) {
			String plural = value > 1 ? "s" : " ";
			return value + " " + unit + plural  ; 
		}
		
		return "";
	}

}
