package view;

import java.util.Scanner;

public class Ex02CreatePassword {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		int WrongTime = 0;
		while (true) {
			System.out.println("Nhập mật khẩu: ");
			String str = ip.nextLine();
			try {
				System.out.println("Mật khẩu hợp lệ: " + text(str));
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				WrongTime++;
			}
			if (WrongTime >= 5) {
				System.out.println("Số lần nhập không vượt quá 5 lần");
				break;
			}
		}
		ip.close();

	}

	private static String text(String str) {

		if (!TextOfChar(str)) {
			throw new IllegalArgumentException("Kí tự phải >= 8 và <= 256 ký tự");
		}

		if (!AlphaOfChar(str)) {
			throw new IllegalArgumentException("Phải có ít nhất 1 chữ hoa và 1 chữ thường");
		}

		if (!NumSpecialOfChar(str)) {
			throw new IllegalArgumentException("Phải có ít nhất 1 chữ số và 1 ký tự đặc biệt");
		}

		return str;
	}

	private static boolean NumSpecialOfChar(String t) {

		boolean number = false;
		boolean special = false;

		for (char c : t.toCharArray()) {
			if (Character.isDigit(c)) {
				number = true;
			}
			if (!Character.isLetterOrDigit(c)) {
				special = true;
			}

			if (number && special) {
				return true;
			}
		}

		return false;
	}

	private static boolean AlphaOfChar(String t) {

		boolean uppercase = false;
		boolean lowercase = false;

		for (char c : t.toCharArray()) {
			if (Character.isUpperCase(c)) {
				uppercase = true;
			}
			if (Character.isLowerCase(c)) {
				lowercase = true;
			}

			if (uppercase && lowercase) {
				return true;
			}
		}
		return false;
	}

	private static boolean TextOfChar(String t) {
		return t.length() >= 8 && t.length() <= 256;
	}

}
