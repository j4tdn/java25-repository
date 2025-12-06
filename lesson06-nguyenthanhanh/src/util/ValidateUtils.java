package util;

public class ValidateUtils {
	
	private ValidateUtils() {
		
	}

	public static boolean isLowercase(char c) {
        return c >= 'a' && c <= 'z';
    }

	public static boolean isUppercase(char c) {
        return c >= 'A' && c <= 'Z';
    }

	public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
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
