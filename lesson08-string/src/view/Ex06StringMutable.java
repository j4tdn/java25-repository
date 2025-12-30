package view;

import java.util.Arrays;

public class Ex06StringMutable {

	public static void main(String[] args) {
		
		// Lien quan den cap nhat gia tri cua mot chuoi nhieu lan(gan, them, xoa, sua ki tu trong chuoi)
		// Can nhac nen dung String mutable
		String[] words = getWords("Grid Layout. This is a type of layout in Java Swing Language");
		System.out.println("words: " + Arrays.toString(words));

	}
	
	private static String[] getWords(String s) {
		if (s == null || s.isBlank()) {
			return null;
		}

		int begin = 0;
		
		String[] words = new String[s.length()];
		
		int count = 0;
		
		StringBuilder word = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			char letter = s.charAt(i);
			if (isLetter(letter)) {
//				if(!isInWord(begin)) {
//					begin = i;
//				}
//				word += letter;
				word.append(letter);
			}else {
//				if(isInWord(begin)) {
//					String word = s.substring(begin,i);
//					System.out.println("|||" + word + "|||");
//					words[count++] = s.substring(begin,i);
//					begin = -1;
//				}
				
				if(!word.isEmpty()) {
					words[count++] = word.toString();
					word.setLength(0);
//					word.delete(0, word.length());
				}
			}
		}
		
//		if(isInWord(begin)) {
//			String word = s.substring(begin, s.length());
//			System.out.println(word);
//			words[count++] = s.substring(begin,s.length());
//		}
		
		if(!word.isEmpty()) {
			words[count++] = word.toString();
		}
		
		return Arrays.copyOfRange(words, 0, count);
	}

	private static boolean isLetter(char letter) {
		return Character.isLetter(letter) || Character.isDigit(letter);
	}

}
