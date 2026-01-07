package view;

public class Ex04Register {

	public static void main(String[] args) {
		System.out.println(validatePassword("@Admin123456"));
	}
	
	private static boolean validatePassword(String password) {
		if(password.isEmpty()) {
			return false;
		}
		if(password.length() < 8) {
			return false;
		}
		
		boolean hasNumber = false;
		boolean hasUpperChar = false;
		boolean hasSpecialChar = false;
		for(int i = 0; i < password.length(); i++) {
			char letter = password.charAt(i);
			if(letter >= '0' && letter <= '9') {
				hasNumber = true;
			}
			if(letter >= 'A' && letter <= 'Z') {
				hasUpperChar = true;
			}
			if(isSpecialChar(letter)) {
				hasSpecialChar = true;
			}
		}
		if(!hasNumber || !hasSpecialChar || !hasUpperChar) {
			throw new IllegalArgumentException("Password is invalid");
		}
		
		if(isPasswordHasMore3CommonsWithUsername(password, "byztkhx256")) {
			throw new IllegalArgumentException("Password should not have more than 3 commons");
		}
		
		return true;
	}
	
	private static boolean isPasswordHasMore3CommonsWithUsername(String password, String username) {
		boolean[] visitedChar = new boolean[1000];
		int count = 0;
		for(int i = 0;  i < username.length(); i++) {
			char uLetter = username.charAt(i);
			for(int j = 0;  j < password.length(); j++) {
				char pLetter = password.charAt(j);
				if(pLetter == uLetter) {
					count++;
				} else {
					visitedChar[pLetter] = true;	
				}
			}
		}
		System.out.println(count);
		return count > 3;
	}
	
	
	private static boolean isSpecialChar(char letter) {
		return letter == '(' || letter == '!' || letter == '@'
				|| letter == '#' || letter == '$' || letter == '%'
				|| letter == '^' || letter == '&' || letter == '*'
				|| letter == ')';
	}
	
}
