package view;

import java.util.Arrays;

public class Ex06StringMutable {
	
	public static void main(String[] args) {
		
		String[] words = getWords("Grid layout. This is a type of layout int Java Swwing language");
		System.out.println("words: " +Arrays.toString(words));
		
		
	}
	
	private static String[] getWords(String s) {
		if(s == null || s.isBlank()) {
			return null;
		}
		
		int begin = 0;
		for(int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if(isLetter(letter)) {
				if(isInWord(begin)) {
					if(i == s.length()-1) {
						String word = s.substring(begin, s.length());
						System.out.println("|||" + word + "|||");
					}
					continue;
				}else {
					begin = i;
				}
			}else {
				if(isInWord(begin)) {
					String word = s.substring(begin, i);
					System.out.println("|||" + word + "|||");
					begin = -1;
					
				}else {
					continue;
				}
			}
		}
		return null;
	}
	
	private static boolean isInWord(int begin) {
		return begin != -1;
		
	}
	
	private static boolean isLetter(char letter) {
		return Character.isLetter(letter) || Character.isDigit(letter);
	}
	

}
