package ex01;

import java.util.Scanner;

public class Ex01MinFact {

	private static final Scanner ip = new Scanner(System.in);
	private static Ex01MinFact df;

	/**
	 * Bài 1 (20đ):Viết chương trình nhập vào 1 số thực có phần thập phân khác 0.
	 * Yêu cầu nhập lại(tối đa 3 lần) nếu nhập sai Sau đó tìm phân số tối giản của
	 * số thập phân đó. Ví dụ 
	 * ▪ 0.1 → 1/10 
	 * ▪ 0.2 → 1/5 
	 * ▪ 0.04 → 1/25 
	 * ▪ 0.75 → 3/4 
	 * ▪ 1.5 → 3/2
	 */
	public static void main(String[] args) {
		double[] numbers = { 0.1, 0.2, 0.04, 0.75, 1.5 };

		for (double number : numbers) {
			System.out.printf("Phân số tối giản của %s là %s\n", number, getMinFact(number));
		}
	}

	private static String format(double val) {
		return df.format(val);
	}

	private static String getMinFact(Double number) {
		String numberAsText = String.valueOf(number);
		String[] parts = numberAsText.split("\\.");
		String intPart = parts[0];
		String decimalPart = parts[1];

		double numerator = Integer.parseInt(intPart) * Math.pow(10, decimalPart.length())
				+ Integer.parseInt(decimalPart);
		double denominator = Math.pow(10, decimalPart.length());
		double gcd = gcd(numerator, denominator);

		return format(numerator / gcd) + "/" + format(denominator / gcd);

	}

	private static double gcd(double n1, double n2) {
		if (n1 == 0)
			return n2;
		if (n2 == 0)
			return n1;
		while (n1 != n2) {
			if (n1 > n2) {
				n1 -= n2;
			} else {
				n2 -= n1;
			}
		}
		return n1;
	}

	private static double inputDecimalNumber() {
		String text = "";
		int wrongTimes = 0;
		do {
			System.out.println("Nhập số thập phân: ");
			text = ip.nextLine();
			if (isDecimalNumber(text)) {
				break;
			}
			if (++wrongTimes == 3) {
				System.out.println("Sai quá 3 lần. Thoát chương trình ...");
				System.exit(0);
			}
		} while (true);
		return Double.parseDouble(text);
	}

	// Cách 2: Dùng biểu thức chính quy
	// Số thực gồm: phần bên trái (ít nhất 1 chữ số), dấu Chấm(.), phần bên phải (ít
	// nhất 1 chữ số)
	private static boolean isDecimalNumberUsingRegex(String text) {
		if (text.matches("\\d+\\.\\d+")) {
			double val = Double.parseDouble(text);
			return Math.floor(val) != val;
		}
		return false;
	}

	// Cách 1: Dùng Logic
	private static boolean isDecimalNumber(String text) {
		String[] parts = text.split("\\.");

		if (parts.length != 2) {
			return false;
		}
		String intPart = parts[0];
		String decimalPart = parts[1];
		return isNumber(intPart) && isNumber(decimalPart) && Integer.parseInt(decimalPart) > 0;

	}

	private static boolean isNumber(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
