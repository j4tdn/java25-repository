package view;

import java.util.Scanner;

public class Ex06IoValidation {
	public static void main(String[] args) {
		
		/*
		 Enter and validate a valid number?
		 -------------------
		 e.g: + Enter number: abc
		 */
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhập vào một số nguyên: ");
		
		//ip.nextLine() phải nhập kí tự số cho đúng
		
		String text;
		do{
			System.out.println("Nhập vào một số nguyên: ");
			text = ip.nextLine();
		}while(true);
			
		
		
		int number = Integer.parseInt(text);
		
		System.out.println("Giá trị hợp lệ: " + number);
		
		ip.close();
		
		/*
		 * Exception in thread "main" java.lang.NumberFormatException: For input string:
		 * "a" at java.base/java.lang.NumberFormatException.forInputString(
		 * NumberFormatException.java:67) at
		 * java.base/java.lang.Integer.parseInt(Integer.java:662) at
		 * java.base/java.lang.Integer.parseInt(Integer.java:778) at
		 * view.Ex06IoValidation.main(Ex06IoValidation.java:17)
		 */
		
	}
	

}
