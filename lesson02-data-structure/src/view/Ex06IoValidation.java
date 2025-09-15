package view;

import java.util.Scanner;

public class Ex06IoValidation {
	public static void main(String[] args) {
		
		
		// ip.nextLine() phai nhap ki tu so cho dung
		Scanner ip = new Scanner(System.in);
		String text;
		int wrongTimes =0;
		do {
			System.out.println("Enter number: ");
			text = ip.nextLine();
			// "a35"
			// kiem tra neu text la [day] so hop le thi break, ko thi cu nhap lai
			// text la so khi tat ca cac ki tu de la so
			// neu ton tai 1 ki tu ko phai la so --> text ko phai la so hop le

			if (isValidText(text)) {
				break;
			}
			
			wrongTimes++;
			System.out.printf("Chua phai la so hop le(lan %s)\n", wrongTimes);
			if(wrongTimes ==4) {
				System.out.println("so lan nhap sai vuot qua 3 lan, thoat");
				ip.close();
				return;
			}
		} while (true);

		int number = Integer.parseInt(ip.nextLine());

		System.out.println("gia tri hop le: " + number);

		ip.close();

		/*
		 * Exception in thread "main" java.lang.NumberFormatException: For input string:
		 * "a" at java.base/java.lang.NumberFormatException.forInputString(
		 * NumberFormatException.java:67) at
		 * java.base/java.lang.Integer.parseInt(Integer.java:662) at
		 * java.base/java.lang.Integer.parseInt(Integer.java:778) at
		 * view.Ex06IoValidation.main(Ex06IoValidation.java:12)
		 * 
		 */

	}
	private static boolean isValidText(String text) {
		for(int i = 0; i < text.length(); i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
			
		} return true;
	}
}
