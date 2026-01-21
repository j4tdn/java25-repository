package view;

public class Ex03StringOperations {
	public static void main(String[] args) {
		String s = "Grid";
		String s1 = "Layout";

		// 1. Tính chiều dài của chuỗi s
		System.out.println(s.length() + "\n");

		// 2. Nối chuỗi s1 vào chuỗi s --> lưu kết quả vào chuỗi s
		s = s + " " + s1;
		System.out.println(s + "\n");
		// 3. Lấy một ký tự tại vị trí index(3) trong chuỗi s
		char c = s.charAt(3);
		System.out.println(c + "\n");
		// 4. Duyệt từng kí tự sau đó in ra mỗi kí tự trong mỗi hàng
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}

		System.out.println("\n");
		// 5. Duyện và in ra từng từ trong chuỗi, biết rằng các từ cách nhau bởi khoảng
		// trắng
		String[] words = s.split("");
		for (String w : words) {
			System.out.print(w);
		}

		s.replace("[ \\.-]+", " ").strip();
		System.out.println("\n5. s(new): " + s);

		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (letter == ' ') {
				String word = s.substring(start, i);
				System.out.println(word.trim());
				start = i++;
			}
		}

		System.out.println("\n");
		// 6. Tìm vị trí(chỉ số) xuất hiện đầu tiên, cuối cùng của kí tự 'a' trong chuỗi
		// s
		int first = s.indexOf('a');
		int last = s.lastIndexOf('a');
		System.out.println(first);
		System.out.println(last);

		System.out.println("=========================");

		printWords("    Grid Layout. This  a type of layout in java String language         ");
	}

	// Grid Layout This a type of layout in java String language

	// trim
	// strip stripLeading, stripTrailing
	private static void printWords(String s) {
		if (s == null || s.isBlank()) {
			return;
		}

		Integer begin = null; // vi tri bat dau cua moi tu, quy uoc begin == -1(chua start word)
		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (isLetter(letter)) {
				if (isInWord(begin)) {
					continue;
				} else {
					begin = i;

				}
			} else {
				if (isInWord(begin)) {
					String word = s.substring(begin, i);
					System.out.println("|||" + word + "|||");
					begin = -1;
				}
			}

		}
		// xu ly cho tu cuoi cung
		// neu duyet xong chuoi ma begin != -1 --> van in
		// se cat va in ra tu do
		if (isInWord(begin)) {
			String word = s.substring(begin, s.length());
			System.out.println("|||" + word + "|||");

		}

	}

	private static boolean isInWord(Integer begin) {
		return begin != null && begin != -1;
	}

	private static boolean isLetter(char letter) {
		return Character.isLetter(letter) || Character.isDigit(letter);
	}

}
