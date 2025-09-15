package view;

import java.util.Scanner;

public class Ex06Iovalidation {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		String text;
		int wrongTimes = 0;
		do {
			System.out.println("nhập vào một số nguyên: ");
			text = ip.nextLine();
			if (isValidText(text)) {
				break;
			}
		
			if(++wrongTimes == 4) {
				System.out.println("số lần nhập sai vượt quá 3 lần, thoát");
				ip.close();
				return;
			}	
			System.out.printf("chưa phải là so hợp lệ (lần %s)\n\n" ,wrongTimes);
		} while (true);

		int number = Integer.parseInt(text);

		System.out.println("giá trị hợp lê: " + number);

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
