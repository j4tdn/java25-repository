package utils;

public class DateTimeUtils {
	public static void main(String[] args) {
		 
	}

    private DateTimeUtils() {
	
   }
	public static String getUnitValue(int value,String unit) {
		if(value != 0) {
			String piural = value >1 ?"s ": " ";
			return value +" "+ unit +piural;
			
		}
		return "";
		
	}

}
