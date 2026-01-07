package bai2;

public class LargestNumbers {
	public static void main(String[] args) {
		String[] r1 = getLargestNumbers("aa6b546c6e22h", "aa6b326c6e22h");
		for (String s : r1) {
			System.out.println(s + "");
		}
	}

	public static String[] getLargestNumbers(String... ss) {
		String[] largetNumber = new String[ss.length];

		for (int i = 0; i < ss.length; i++) {
			String s = ss[i] + "a";
			String current = "";
			String maxNumber = "0";
			boolean hasZero = false;
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (Character.isDigit(c)) {
					if (current.isEmpty() && c == '0') {
						hasZero = true;

					} else {
						current += c;
					}
				} else {
					if (!current.isEmpty()) {
						if (compare(maxNumber, current) > 0) {
							maxNumber = current;
						}
						current = "";
						hasZero = false;
					} else if (hasZero) {
						maxNumber = "0";
						hasZero = false;
					}

				}
				largetNumber[i] = hasZero ? maxNumber : "0";
			}

		}
		for (int i = 0; i < largetNumber.length - 1; i++) {
			for (int j = i + 1; j < largetNumber.length; j++) {
				String tmp = largetNumber[i];
				largetNumber[i] = largetNumber[j];
				largetNumber[j] = tmp;

			}
		}
		return largetNumber;

	}

	private static int compare(String a, String b) {
		if (a.length() > b.length())
			return 1;
		if (a.length() < b.length())
			return -1;
		if (a.length() == b.length()) {
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) < b.charAt(i))
					return -1;
				if (a.charAt(i) > b.charAt(i))
					return 1;
			}
		}
		return 0;

	}

}
