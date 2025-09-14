package view;

import java.util.Scanner;

public class Ex06IOValidation {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		String text;
		int wrongTimes = 0;
		do {
			System.out.print("Nhập vào 1 số nguyên: ");
			text = ip.nextLine();		
			if(isValidText(text)) {
				break;
			}
			
			wrongTimes++;
			System.out.printf("Chưa phải số hợp lệ, số lần nhập(%s)\n", wrongTimes);
			if(wrongTimes == 3) {
				System.out.println("Số lần nhập vượt quá 3 lần, thoát");
				ip.close();
				return;
			}
		} while(true);
		
		int number = Integer.parseInt(text);
		
		System.out.println("Giá trị hợp lệ: " + number);
		
		ip.close();
		
	}
	
	private static boolean isValidText(String text) {
		for(int i = 0; i < text.length(); i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
	
}
