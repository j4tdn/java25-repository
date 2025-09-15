package homework.lesson02;

import java.util.Scanner;

public class Ex05Symmetrical {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		while (true) {
			System.out.println("Nhap N");
			String text = ip.nextLine();

			if (isValidText(text)) {
				System.out.println(isSymmertrical(text));
				break;
			} else {
				System.out.println("Không phải là số nguyên, nhập lại");

			}
		}
		ip.close();

	}

	private static boolean isSymmertrical(String val) {

		int left = 0;
		int right = val.length() - 1;

		while (left < right) {
			if (val.charAt(left) != val.charAt(right)) {
				return false;
			}
			left++;
			right--;
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
