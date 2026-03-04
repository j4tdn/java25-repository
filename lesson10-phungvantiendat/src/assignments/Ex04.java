package assignments;

import java.util.Arrays;
import static utils.PrintUtils.*;

public class Ex04 {
	public static void main(String[] args) {
		String[] strings = { "-2", "-6", "10", null, "4", "8", null, "Special", "a", "c", "b", "xx" };

		Arrays.sort(strings, (s1, s2) -> {

			if (s1 == null) {
				return 1;
			}

			if (s2 == null) {
				return -1;
			}

			if ("Special".equals(s1) && !"Special".equals(s2)) {
				return -1;
			}
			if (!"Special".equals(s1) && "Special".equals(s2)) {
				return 1;
			}

			if (s1 != null && s2 != null && !Character.isLetter(s1.charAt(0)) && !Character.isLetter(s2.charAt(0))) {
				int number1 = Integer.parseInt((String) s1);
				int number2 = Integer.parseInt((String) s2);

				if (number1 < 0 && number2 < 0) {
					return Integer.compare(number1, number2);
				}

				if (number1 > 0 && number2 > 0) {
					return Integer.compare(number1, number2);
				}
			}
			return s1.compareTo(s2);
		});

		generate("1. Tăng dần: Special => số âm tăng dần => số dương tăng dần => chuỗi tăng dần", strings);

		Arrays.sort(strings, (s1, s2) -> {
			if (s1 == null && s2 != null) {
				return -1;
			}

			if (s2 == null) {
				return 1;
			}

			if ("Special".equals(s1) && !"Special".equals(s2)) {
				return 1;
			}
			if (!"Special".equals(s1) && "Special".equals(s2)) {
				return -1;
			}

			if (s1 != null && s2 != null && !Character.isLetter(s1.charAt(0)) && !Character.isLetter(s2.charAt(0))) {
				int number1 = Integer.parseInt((String) s1);
				int number2 = Integer.parseInt((String) s2);

				if (number1 < 0 && number2 < 0) {
					return Integer.compare(number2, number1);
				}

				if (number1 > 0 && number2 > 0) {
					return Integer.compare(number2, number1);
				}
			}
			return s2.compareTo(s1);
		});

		generate("2. Giảm dần: Giảm dần các chuỗi trong mảng => số dương giảm dần => số âm giảm dần\r\n" + "=> Special",
				strings);
	}
}
