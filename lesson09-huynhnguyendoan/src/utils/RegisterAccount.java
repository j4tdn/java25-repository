package utils;

public class RegisterAccount {
	public static boolean isValidLength(String password) {
		return password.length() >= 8;
	}

	public static boolean hasUpperCase(String password) {
		for (char c : password.toCharArray()) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasDigit(String password) {
		for (char c : password.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;

			}
		}
		return false;

	}

	public static boolean hasSpecialCharacter(String password) {
		String special = "~!@#$%^&*";
		for (char c : password.toCharArray()) {
			if (special.indexOf(c) != 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNotSimilarOver3(String username, String password) {
		for (int i = 0; i <= password.length() - 3; i++) {
			String sub = password.substring(i, i + 3);
			if (username.contains(sub)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidPassword(String username, String password) {
		return isValidLength(password) && hasUpperCase(password) && hasDigit(password) && hasSpecialCharacter(password)
				&& isNotSimilarOver3(username, password);
	}
}
