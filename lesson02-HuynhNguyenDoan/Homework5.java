package homework;

import java.util.Scanner;

public class Homework5 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String textCheck;
		do {
			System.out.println("Nhap so: ");
			textCheck = ip.nextLine();
			if (isValidNumber(textCheck)) {
				break;
			}
			System.out.println("Chua phai la so hop le, yeu cau nhap lai");
		} while (true);
		ip.close();
		int numberCheck = Integer.parseInt(textCheck);
		if (mirrorNumber(numberCheck) == true) {
			System.out.println(numberCheck + " La so doi xung");
		} else {
			System.out.println(numberCheck + " Khong phai la so doi xung");
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

	private static boolean mirrorNumber(int numberCheck) {
		int originalNumber = numberCheck;
		int reverseNumber = 0;

		while (numberCheck > 0) {
			int lastDigit = numberCheck % 10;
			reverseNumber = reverseNumber * 10 + lastDigit;
			numberCheck /= 10;
		}
		if (originalNumber == reverseNumber) {
			return true;
		} else {
			return false;
		}

	}
}
