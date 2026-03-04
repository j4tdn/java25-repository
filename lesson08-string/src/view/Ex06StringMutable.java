package view;

import java.util.Arrays;

public class Ex06StringMutable {
	
	public static void main(String[] args) {
		
		// Liên quan đến cập nhật giá trị của một chuỗi nhiều lần(gán, thêm, xóa, sửa kí tự trong chuỗi)
		// Cân nhắc nên dùng String Mutable
		
		String[] words = getWords("Grid Layout. This is a type of layout in Java Swing language");
		System.out.println("words: " + Arrays.toString(words));
	}
	
	private static String[] getWords(String s) {
		if (s == null || s.isBlank()) {
			return null;
		}
		
		int count = 0;
		String[] words = new String[s.length()];
		// String word = ""; // immutable
		StringBuffer word = new StringBuffer(); // mutable

		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (isLetter(letter)) {
				word.append(letter);
				System.out.println(System.identityHashCode(word));
			} else {
				if (!word.isEmpty()) {
					words[count++] = word.toString();
					word.delete(0, word.length()); // gán về rỗng
				}
			}
		}
		
		if (!word.isEmpty()) {
			words[count++] = word.toString();
		}

		return Arrays.copyOfRange(words, 0, count);
	}

	private static boolean isLetter(char letter) {
		return Character.isLetter(letter) || Character.isDigit(letter);
	}
	
}