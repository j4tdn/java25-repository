package homework;

import java.util.Scanner;

public class Homework2 {
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

		int isPowerOfTwo = Integer.parseInt(textCheck);

		 boolean check = isPowerOfTwo > 0 && (isPowerOfTwo & (isPowerOfTwo - 1)) == 0;
	        System.out.println(check ? "true" : "false");

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
