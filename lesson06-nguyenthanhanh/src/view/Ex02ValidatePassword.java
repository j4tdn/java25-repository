package view;

import java.util.Scanner;

import exception.PasswordException;
import static util.ValidateUtils.*;

public class Ex02ValidatePassword {
	
	private static Scanner ip = new Scanner(System.in);
	
	private static final int MAX_WRONG_TIMES = 5;
	private static final String SPECIAL_CHARS = "(~!@#$%^&*()-_=+[]{}|;:,.<>/?)";
	private static final int MAX_LENGTH = 256;
	private static final int MIN_LENGTH = 8;

	public static void main(String[] args) {
		System.out.println("=== Chương trình kiểm tra tính hợp lệ của mật khẩu khi đăng ký tài khoản ===");
		try {
			String password = inputPassword("Nhập vào mật khẩu hợp lệ: ");
			System.out.println("Mật khẩu của bạn là: " + password);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ip.close();
		}
	}
	
	private static String inputPassword(String message) {
		String text = null;
		int count = 0;
		do {
			System.out.print(message);
			text = ip.nextLine();
			try {
				if(validatePassword(text)) {
					return text;
				}
			} catch(PasswordException ex) {
				count++;
				System.out.println("Sai " + count + " lần, lỗi: " + ex.getMessage());
				if (count == MAX_WRONG_TIMES) {
					throw new RuntimeException("=== Vượt quá số lần nhập sai cho phép, chương trình dừng ===");
				}
			}
		}
		while(true);
	}
	
	private static boolean validatePassword(String password) {
		if(password == null) {
			throw new PasswordException("Mật khẩu không được null.");
		}
		
		int passwordLength = password.length();
		if (passwordLength < MIN_LENGTH) {
			throw new PasswordException("Mật khẩu phải có ít nhất " + MIN_LENGTH + " ký tự.");
		}
        if (passwordLength > MAX_LENGTH) {
        	throw new PasswordException("Mật khẩu không được vượt quá " + MAX_LENGTH + " ký tự.");
        }
        
        boolean hasLowerChar = false;
        boolean hasUpperChar = false;
        boolean hasDigitChar = false;
        boolean hasSpecialChar = false;
        for(int i = 0; i < passwordLength; i++) {
        	char c = password.charAt(i);
        	 if (isLowercase(c)) {
        		 hasLowerChar = true;
        	 }
             else if (isUppercase(c)) {
            	 hasUpperChar = true;
             }
             else if (isDigit(c)) {
            	 hasDigitChar = true;
             }
             else if (isSpecial(c)) {
            	 hasSpecialChar = true;
             }
        }
        if (!hasLowerChar) {
        	throw new PasswordException("Phải có ít nhất một chữ thường (a-z).");
        }
        if (!hasUpperChar) {
        	throw new PasswordException("Phải có ít nhất một chữ hoa (A-Z).");
        }
        if (!hasDigitChar) {
        	throw new PasswordException("Phải có ít nhất một chữ số (0-9).");
        }
        if (!hasSpecialChar) {
        	throw new PasswordException("Phải có ít nhất một ký tự đặc biệt: " + SPECIAL_CHARS);
        }
        
        return true;
	}
	

    private static boolean isSpecial(char c) {
        for (int i = 0; i < SPECIAL_CHARS.length(); i++) {
            if (c == SPECIAL_CHARS.charAt(i)) {
            	return true;
            }
        }
        return false;
    }
	
}
