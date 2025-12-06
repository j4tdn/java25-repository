package utils;

import exception.NumberValidException;

public class NumberUtils {
	private static int countDigits(int number) {
		int cnt = 0;
		if (number == 0) {
			return 1;
		}
		while (number != 0) {
			++cnt;
			number /= 10;
		}
		return cnt;
	}

	private static boolean hasAtMostThreeDigits(int number) {
		return countDigits(number) <= 3;
	}

	public static boolean isValidDigit(int number) {
		if (!hasAtMostThreeDigits(number)) {
			throw new NumberValidException("Vui lòng nhập số hợp lệ tối đa ba chữ số");
		}
		return true;
	}

	private static String readNumberWithOneDigit(int number) {
		String value = "";
		switch (number) {
		case 0:
			value = "Không";
			break;
		case 1:
			value = "Một";
			break;
		case 2:
			value = "Hai";
			break;
		case 3:
			value = "Ba";
			break;
		case 4:
			value = "Bốn";
			break;
		case 5:
			value = "Năm";
			break;
		case 7:
			value = "Bảy";
			break;
		case 8:
			value = "Tám";
			break;
		case 9:
			value = "Chín";
			break;
		default:
			break;
		}
		return value;
	}

	private static String readNumberWithTwoDigits(int number) {
		int greater = number / 10;
		int less = number % 10;

		String greaterValue = "";
		String lessValue = "";

		switch (greater) {
		case 1:
			greaterValue = "Mười";
			break;
		case 2:
			greaterValue = "Hai mươi";
			break;
		case 3:
			greaterValue = "Ba mươi";
			break;
		case 4:
			greaterValue = "Bốn mươi";
			break;
		case 5:
			greaterValue = "Năm mươi";
			break;
		case 6:
			greaterValue = "Sáu mươi";
			break;
		case 7:
			greaterValue = "Bảy mươi";
			break;
		case 8:
			greaterValue = "Tám mươi";
			break;
		case 9:
			greaterValue = "Chín mươi";
			break;
		default:
			break;
		}

		if (greaterValue.equalsIgnoreCase("Mười")) {
			if (less == 5) {
				lessValue = "lăm";
			} else {
				lessValue = readNumberWithOneDigit(less);
			}
		} else {
			if (less == 5) {
				lessValue = "lăm";
			} else if (less == 1) {
				lessValue = "mốt";
			} else {
				lessValue = readNumberWithOneDigit(less);
			}
		}
		return greaterValue + " " + lessValue;
	}
	
	private static String readNumberWithThreeDigits(int number) {
		int greatest = (number / 100);
		String greatestValue = "";
		int greater = (number % 100);
		switch (greatest) {
		case 1:
			greatestValue = "Một trăm";
			break;
		case 2:
			greatestValue = "Hai trăm";
			break;
		case 3:
			greatestValue = "Ba trăm";
			break;
		case 4:
			greatestValue = "Bốn trăm";
			break;
		case 5:
			greatestValue = "Năm trăm";
			break;
		case 6:
			greatestValue = "Sáu trăm";
			break;
		case 7:
			greatestValue = "Bảy trăm";
			break;
		case 8:
			greatestValue = "Tám trăm";
			break;
		case 9:
			greatestValue = "Chín trăm";
			break;
		default:
			break;
		}
		
		return greatestValue+ " " + readNumberWithTwoDigits(greater);
	}

	public static String readNumber(int number) {
		int quantity = countDigits(number);
		if(quantity == 1) {
			return readNumberWithOneDigit(number);
		}else if(quantity == 2) {
			return readNumberWithTwoDigits(number);
		}else {
			return readNumberWithThreeDigits(number);
		}
	}
}
