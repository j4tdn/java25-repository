package view;

import java.util.Scanner;

public class Ex06IoValidation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text;
		int wrongTimes = 0;
		do {
			System.out.println("Nhap vao mot so nguyen: ");
			text = sc.nextLine();
			if(isValidText(text)) {
				break;
			}
			++wrongTimes;
			if(wrongTimes > 3) {
				System.out.println("Nhap sai qua 3 lan ");
				return;
			}
			System.out.printf("Chua phai la so hop le(lan %s)\n", wrongTimes);
		} while (true);
		int number = Integer.parseInt(text);
		System.out.println("Gia tri hop le: "+ number);
		sc.close();
	}
	
	private static boolean isValidText(String text) {
		for(int i = 0;i < text.length(); ++i) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
