package bai3;

public class StringUtil {
	public static void main(String[] args) {
		String s = "Welcome to JAVA10 class";
		System.out.println(revert(s));
	}

	public static String revert(String s) {
		String cleaned = "";
		boolean space = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ') {
				cleaned += c;
				space = false;

			} else if (!space) {
				cleaned += ' ';
				space = true;
			}

		}

		if (cleaned.length() > 0 && cleaned.charAt(cleaned.length() - 1) == ' ') {
			cleaned = cleaned.substring(0, cleaned.length() - 1);
		}

		String result = "";
		String word = "";

		for (int i = 0; i <= cleaned.length(); i++) {
			if (i == cleaned.length() || cleaned.charAt(i) == ' ') {
				for (int j = word.length() - 1; j >= 0; j--) {
					result += word.charAt(j);
				}
				if (i < cleaned.length()) {
					result += ' ';
				}
				word = "";

			} else {
				word += cleaned.charAt(i);
			}
		}
		return result;
	}

}
