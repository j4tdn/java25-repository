package view;

import java.util.Scanner;

public class Ex06IoValidation {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		String text;
		int count =0;
		do {
			System.out.print ("Nhập vào 1 số nguyên: ");
			text= ip.nextLine();
			if(isValidText(text)) {
				break;
			}
			count++;
			System.out.println("Chưa phải là số hợp lệ \n");
			if(count ==3) {
				System.out.println("Đã quá số lần nhập");
				return;
			}
		} while(true);
		int number =Integer.parseInt(text);
		
		System.out.println("Số hợp lệ là: "+number);
		
		ip.close();
	}
	private static boolean isValidText(String text) {
		for(int i=0;i<text.length();i++) {
			
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
