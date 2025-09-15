package homework;

import java.util.Scanner;

public class Homework8 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String textCheck;
		int wrongCount = 0;
		do {
			System.out.println("Nhap so:");

			textCheck = ip.nextLine();
			if (isValidNumber(textCheck)) {
				break;
			}
			wrongCount++;
			System.out.printf("Yeu cau nhap lai: (So lan con lai co the nhap:%s)", wrongCount);
			if (wrongCount == 6) {
				System.out.println("Da dat toi da so lan nhap lai");
				ip.close();
			}
		} while (true);
		int number = Integer.parseInt(textCheck);

		if (isPrimeNumber(number)) {
			System.out.println(number + " la so nguyen to");
		} else {
			System.out.println(number + " khong phai la so nguyen to");
		}
		ip.close();

	}

	private static boolean isValidNumber(String textCheck) {
		for (int i = 0; i < textCheck.length(); i++) {
			if (!Character.isDigit(textCheck.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static boolean isPrimeNumber(int number) {
		if (number <= 1) {
			System.out.println("false");
		}
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
