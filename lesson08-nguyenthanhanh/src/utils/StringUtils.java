package utils;

import java.util.Scanner;

public class StringUtils {
	
	private static Scanner ip = new Scanner(System.in);

	private StringUtils() {
		
	}
	
	public static int inputNumber(String message) {
		String text = null;
		System.out.print(message);
		text = ip.nextLine();
		if(!isNumber(text)) {
			throw new IllegalArgumentException("Dữ liệu số không hợp lệ");
		}
		return Integer.parseInt(text);
	}
	
	public static String inputString(String message, boolean isVietnamese) {
		String text = null;
		System.out.print(message);
		text = ip.nextLine();
		if(isVietnamese) {
			if(!isVietNameseString(text)) {
				throw new IllegalArgumentException("Dữ liệu unicode không hợp lệ");
			}
		} else if(!isString(text)) {
			throw new IllegalArgumentException("Dữ liệu không hợp lệ");
		}
		return text;
	}
	
	public static boolean isVietNameseString(String text) {
		if(text.isEmpty() || text == null) {
			return false;
		}
		
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			
			if(c == ' ') {
				continue;
			}
			
			if(!Character.isLetter(c)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isString(String text) {
		if(text.isEmpty() || text == null) {
			return false;
		}
		
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			
			if(c == ' ') {
				continue;
			}
			
			if((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isNumber(String text) {
		if(text.isEmpty() || text == null) {
			return false;
		}
		
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);		
			if(c > '9' && c < '0') {
				return false;
			}
		}
		
		return true;
	}
	
}
