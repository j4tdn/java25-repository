package utils;

import java.util.Arrays;

public class StringExtractor {
	public static String[] GetNumbers(String... ss) {
		String[] result = new String[ss.length];
		for (int i = 0; i < ss.length; i++) {
			String s = ss[i];
			long max = 0;
			long current = 0;
			boolean hasDigit = false;

			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if(Character.isDigit(c)) {
					hasDigit = true;
					current = current *10 + (c- '0');
				}
				else {
					max = Math.max(max, current);
					current = 0;
				}
				max = Math.max(max, current);
				if (!hasDigit) {
					result[i] = "0";
				} else {
					result[i] = String.valueOf(max);
				}
			}
			Arrays.sort(result, (a, b) -> Long.compare(Long.parseLong(a), Long.parseLong(b)));
		}
		return result;
	}
}
