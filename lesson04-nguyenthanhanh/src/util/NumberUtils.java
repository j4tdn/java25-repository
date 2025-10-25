package util;

import java.util.Scanner;

public class NumberUtils {
	
	private static Scanner ip = new Scanner(System.in);
	
	private NumberUtils() {
		
	}
	
	public static Integer inputNumber(int maxFailedTime, String message) {
		Integer n = null;
		String text = null;

		int wrongTimes = 0;
		do {
			System.out.printf(message);
			text = ip.nextLine();
			if (isValidNumber(text)) {
				n = Integer.parseInt(text);
				break;
			}
			if (++wrongTimes == maxFailedTime) {
				System.out.println(">> Số lần sai vượt quá " + maxFailedTime + " lần, thoát");
				return null;
			}
		} while (true);

		return n;
	}
	
	public static Integer inputNumber(int minValueExcl, 
			int maxValueExcl, int maxFailedTime, String message) {
		Integer n = null;
		String text = null;

		int wrongTimes = 0;
		do {
			System.out.printf(message, minValueExcl);
			text = ip.nextLine();
			if (isValidNumber(text)) {
				n = Integer.parseInt(text);
				if (n > minValueExcl && n < maxValueExcl) {
					break;
				}
			}
			if (++wrongTimes == maxFailedTime) {
				System.out.println(">> Số lần sai vượt quá " + maxFailedTime + " lần, thoát");
				return null;
			}
		} while (true);

		return n;
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
