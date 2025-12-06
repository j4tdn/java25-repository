package utils;

import java.util.ArrayList;
import java.util.List;

import exception.PasswordException;

public class PasswordUtils {
	private static final String SPECIAL_CHARS = "~!@#$%^&*()_-=+[]{};:,.<>/?";

	private static boolean containsSpecialChar(String password) {
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (SPECIAL_CHARS.indexOf(c) >= 0) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean hasMinimumLength(String password) {
		return password.length() >= 8;
	}
	
	private static boolean hasMaximumLength(String password) {
		return password.length() <= 256;
	}
	
	private static boolean containsLowercase(String password) {
		for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
            	return true;
            }
        }
        return false;
	}
	
	private static boolean containsUppercase(String password) {
		for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
            	return true;
            }
        }
        return false;
	}
	
	private static boolean containsDigit(String password) {
		for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
            	return true;
            }
        }
        return false;
	}
	
	public static boolean isValidPassword(String password) {
		
		List<String> errors = new ArrayList<>();
		
		if(password.isEmpty()) {
			throw new PasswordException();
		}
		
		if(!hasMinimumLength(password)) {
			errors.add("Độ dài mật khẩu phải chứa ít nhất 8 kí tự");
		}
		
		if(!hasMaximumLength(password)) {
			 errors.add("Độ dài mật khẩu không được vượt quá 256 kí tự");
		}
		
		if(!containsLowercase(password)) {
			errors.add("Phải chứa ít nhất 1 kí tự thường");
		}
		
		if(!containsUppercase(password)) {
			errors.add("Phải chứa ít nhất 1 kí tự in hoa");
		}
		
		if(!containsDigit(password)) {
			errors.add("Phải chứa ít nhất 1 kí tự chữ số");
		}
		
		if(!containsSpecialChar(password)) {
			errors.add("Phải chứa ít nhất 1 kí tự đặc biệt");
		}
		
		if(!errors.isEmpty()) {
			throw new PasswordException(errors);
		}
		
		return true;
	}
}
