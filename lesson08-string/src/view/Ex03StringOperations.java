package view;

import java.util.Arrays;

public class Ex03StringOperations {

	public static void main(String[] args) {
		String s = "Grid";
		String s1 = "Layout. This a type of layout in Java Swing language";

		System.out.println("1. Tính chiều dài của chuỗi s: " + s.length());

		s = s + " " + s1; // concatenate s.concat(" ").concat(s1)
		System.out.println("2. Kết quả nối chuỗi: " + s);

		System.out.println("3. Lấy kí tự tại vị trí có index(3): " + s.charAt(3));

		System.out.println("4. Duyệt từng kí tự sau đó in ra mỗi kí tự trong mỗi hàng");
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}

		// replaceAll, split
		System.out.println("5. Duyệt và in ra từng từ trong chuỗi, biết rằng các từ cách nhau bởi khoảng trắng");
//		String[] words = s.split("[ \\.]+");
//		for (String word: words) {
//			System.out.println(word);
//		}

		// Grid Layout This a type of layout in Java Swing language
		s = s.replaceAll("[ \\.-]+", " ").strip();
		System.out.println("5. s(new) --> " + s);

		int startIndexOf = 0;
		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (letter == ' ') {
				String word = s.substring(startIndexOf, i);
				System.out.println(word.trim());
				startIndexOf = i++;
			}
		}

		// 6. Tìm vị trí(chỉ số) xuất hiện đầu tiên, cuối cùng của kí tự 'a' trong chuỗi
		// s
		System.out.println("\n6. Vị trí xuất hiện đầu tiên của kí tự 'a' --> " + s.indexOf("a"));
		System.out.println("6. Vị trí xuất hiện cuối cùng của kí tự 'a' --> " + s.lastIndexOf("a"));

		String[] words = printWords(" #$%^&  Grid --- 562()))  Layout. This is   a type of layout in Java Swing language");
		System.out.println("\n5(words) --> " + Arrays.toString(words));
	}

	private static String[] printWords(String s) {
		if (s == null || s.isBlank()) {
			return null;
		}
		
		int count = 0;
		String[] words = new String[s.length()];
		String word = "";

		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (isLetter(letter)) {
				word = word + letter;
			} else {
				if (!word.isEmpty()) {
					words[count++] = word;
					word = "";
				}
			}
		}
		
		if (!word.isEmpty()) {
			words[count++] = word;
		}

		return Arrays.copyOfRange(words, 0, count);
	}

	private static boolean isLetter(char letter) {
		return Character.isLetter(letter) || Character.isDigit(letter);
	}

}
