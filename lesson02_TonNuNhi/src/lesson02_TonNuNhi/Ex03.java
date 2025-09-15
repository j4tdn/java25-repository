package lesson02_TonNuNhi;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {

		Scanner ip = new Scanner(System.in);
		String text;
		int count = 0;
		int n = -1;

		do {
			System.out.print("Nhập vào 1 số nguyên dương: ");
			text = ip.nextLine();

			if (isValidText(text)) {
				n = Integer.parseInt(text);
				if (n >= 0) {
					break;
				}
			}

			System.out.println("Chưa phải là số hợp lệ \n");

			count = count + 1;
			if (count == 5) {
				System.out.println("Đã quá số lần nhập");
				ip.close();
				return;
			}
		} while (true);

		long res = 1L;
		for (int i = 2; i <= n; i++) {
			res = res * i;
		}

		System.out.println(n + "! = " + res);

		ip.close();
	}

	private static boolean isValidText(String text) {
		if (text == null)
			return false;
		if (text.length() == 0)
			return false;
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
