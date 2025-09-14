package view;

import java.util.Scanner;

public class Ex06IoValidation {
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		String text;
		
		// ve nha: toan tu && || lam cac bai ++ -- trong slide
		//        xem video mang, enum
		int wrongTimes = 0;
		do {
			System.out.println("nhap vao mot so nguyen");
			text = ip.nextLine();
			if (isValidText(text)) {
				break;
			}
			wrongTimes++;
			if (wrongTimes == 3) {
				System.out.println("so lan nhap sai vuot qua 3 lan, thoat");
				ip.close();
				return;
			}
			System.out.printf("chua phai la so hop le(lan %s)\n\n", wrongTimes);
		} while (true);
		
		int number = Integer.parseInt(text);
		System.out.println("gia tri hop le :" + number);
		
		ip.close();
		
    

	}
	
	private static boolean isValidText(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
