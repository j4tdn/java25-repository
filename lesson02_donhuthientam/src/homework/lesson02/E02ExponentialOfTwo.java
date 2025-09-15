package homework.lesson02;

import java.util.Scanner;

public class E02ExponentialOfTwo {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		int wrongTimes = 0;
		do {
			System.out.println("Nhap N");
			String text = ip.nextLine();

			if (isValidText(text)) {
				int number = Integer.parseInt(text);
				System.out.println(isPowerOfTwo(number));
				break;
			} else {
				System.out.println("không phải là số nguyên\n");
			}

			wrongTimes++;
			if (wrongTimes == 5) {
				System.out.println(" Số lần nhập không vượt quá 5 lần");
				ip.close();
				return;
			}
		} while (true);

		ip.close();

	}

	private static boolean isPowerOfTwo(int number) {
		while (number > 1) {
			if (number % 2 != 0) {
				return false;
			}
			number /= 2;
		}
		return true;

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
