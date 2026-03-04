package utils;

public class NumberUtils {

	private NumberUtils() {
		
	}
	
	public static boolean isValidNumber(String text) {
		if(text.length() == 0 || text == null) {
			return false;
		}
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) < '0' || text.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	
}
