package assigment;

public class NumberUtils {
	public static String readNumber(int n) {
		if (n < 0 || n > 999) {
			return "Không hợp lệ";
		}
		String[] numbers = { "không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín" };

		if (n == 0) {
			return capitalize(numbers[0]);
		}
		if (n < 10) {
			return capitalize(numbers[n]);
		}
		int tram = n / 100;
		int chuc = (n / 10) % 10;
		int donvi = n % 10;

		StringBuilder result = new StringBuilder();

		if (tram > 0) {
			result.append(numbers[tram]).append(" trăm ");
		}

		if (chuc == 0) {
			if (tram != 0 && donvi != 0) {
				result.append("lẻ ");
			}
		} else if (chuc == 1) {
			result.append("mười ");
		} else {
			result.append(numbers[chuc]).append(" mươi ");
		}

		if (donvi > 0) {
			if (donvi == 5 && chuc >= 1) {
				result.append("lăm");
			} else if (donvi == 1 && chuc >= 2) {
				result.append("mốt");
			} else {
				result.append(numbers[donvi]);
			}
		}

		return capitalize(result.toString().trim());
	}

	private static String capitalize(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
}
