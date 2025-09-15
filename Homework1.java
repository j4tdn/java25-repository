package homework;

import java.util.Scanner;

public class Homework1 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		String textCheck;
		int wrongTimes = 0;
		do {
			System.out.println("Nhap so: ");
			textCheck = ip.nextLine();

			if (isValidText(textCheck)) {
				break;
			}
			wrongTimes++;
			System.out.printf("Chua phai la so hop le(lan %s),Yeu cau nhap lai:\n", wrongTimes);
			if (wrongTimes == 6) {
				System.out.println("so lan nhap sai vuot qua 3 lan, thoat");
				ip.close();
				return;
			}
		} while (true);

		int number = Integer.parseInt(textCheck);
		if (number % 2 == 0) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		ip.close();

	}

	private static boolean isValidText(String textCheck) {
		for (int i = 0; i < textCheck.length(); i++) {
			if (!Character.isDigit(textCheck.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
