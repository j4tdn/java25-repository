package view;

import java.util.Scanner;

public class Ex04ReadNum {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("NHAP N: ");
		int number = Integer.parseInt(ip.nextLine());

		System.out.printf("%s = %d ==> %s", "n", number, readThreeNumber(number));

	}

	private static String readThreeNumber(int n) {
		
		int hundreds = n / 100;
		int tens = n % 100;

		if (n < 100) {
			return readTwoNumber(n);
		}
		String result = readNumber(hundreds) + " trăm ";

		if (tens == 0) {
			return result;
		}
		if (tens < 10) {
			return result + "linh " + readNumber(tens).toLowerCase();
		}
		return result + "" + readTwoNumber(tens).toLowerCase();
	}

	private static String readTwoNumber(int n) {

		int tens = n / 10;
		int ones = n % 10;

		if (n < 10) {
			return readNumber(n);
		}
		if (tens == 1) {
			return switch (ones) {
			case 0 -> "Mười";
			case 5 -> "Mười lăm";

			default -> "Mười " + "" + readNumber(ones).toLowerCase();

			};
		}

		String result = readNumber(tens) + " mươi ";

		if (ones == 0) {
			return result;
		}
		if (ones == 1) {
			return result + "mốt ";
		}
		if (ones == 5) {
			return result + "lăm ";
		}

		return result + "" + readNumber(ones).toLowerCase();

	}

	private static String readNumber(int n) {
		return switch (n) {
		case 0 -> "Không";
		case 1 -> "Một";
		case 2 -> "Hai";
		case 3 -> "Ba";
		case 4 -> "Bốn";
		case 5 -> "Năm";
		case 6 -> "Sáu";
		case 7 -> "Bảy";
		case 8 -> "Tám";
		case 9 -> "Chín";
		default -> " ";
		};

	}

}
