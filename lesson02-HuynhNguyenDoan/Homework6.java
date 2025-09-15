package homework;

import java.util.Scanner;

public class Homework6 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap so a: ");
		int a = getNumber(ip);
		System.out.println("Nhap so b: ");
		int b = getNumber(ip);
		System.out.println("Nhap so c: ");
		int c = getNumber(ip);

		compareNumber(a, b, c);
		ip.close();

	}

	private static int getNumber(Scanner ip) {
		String textCheck;
		while (true) {
			textCheck = ip.nextLine();
			if (isValidNumber(textCheck)) {
				return Integer.parseInt(textCheck);
			} else {
				System.out.println("Khong phai la so hop le");
			}

		}
	}

	private static boolean isValidNumber(String textCheck) {
		for (int i = 0; i < textCheck.length(); i++) {
			if (!Character.isDigit(textCheck.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static void compareNumber(int a, int b, int c) {
		int max = a;
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		int min = a;
		if (b < min) {
			min = b;
		}
		if (c < min) {
			min = c;
		}
		System.out.println("So lon nhat la: " + max);
		System.out.println("So nho nhat la: " + min);

	}
}
