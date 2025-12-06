package view;

import static util.ValidateUtils.*;

import java.util.Scanner;

import exception.EmailException;

public class Ex03ValidateEmail {
	
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("=== Chương trình cho phép nhập địa chỉ email từ bàn phím. ===");
		try {
			String email = inputEmail("Nhập email của bạn: ");
	        System.out.println("Email của bạn là: " + email);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ip.close();
		}
	}
	
	private static String inputEmail(String message) {
		do {
			System.out.print(message);
            String email = ip.nextLine();
            if (validateEmail(email)) {
                return email;
            } else {
                throw new EmailException();
            }
		} while(true);
	}
	
	private static boolean validateEmail(String email) {
		if (email == null) {
			return false;
		}

        String[] parts = email.split("@");
        if (parts.length != 2) {
        	return false;
        }

        String prefix = parts[0];
        String domain = parts[1];

        if (prefix.isEmpty() || domain.isEmpty()) {
        	return false;
        }

        return isValidPrefix(prefix) && isValidDomain(domain);
	}
	
	private static boolean isValidPrefix(String s) {
	    if (s == null || s.isEmpty()) {
	    	return false;
	    }
	    if (!isLowercase(s.charAt(0)) && !isDigit(s.charAt(0))) {
	    	return false;
	    }

	    boolean isLastWasSeparate = false;
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (isLowercase(c) || isDigit(c)) {
	        	isLastWasSeparate = false;
	        } else if (isSeparate(c)) {
	        	if (isLastWasSeparate) {
	            	return false;
	            };
	            if(i + 1 >= s.length()) {
	            	return false;
	            }
	            if (!isLowercase(s.charAt(i + 1)) && !isDigit(s.charAt(i + 1))) {
	            	return false;
	            }
	            isLastWasSeparate = true;
	        } else {
	            return false;
	        }
	    }

	    return true;
	}

	
	private static boolean isValidDomain(String domain) {
		return "mail.com".equals(domain);
	}
	
	private static boolean isSeparate(char c) {
	    return c == '_' || c == '.' || c == '-';
	}
	
}
