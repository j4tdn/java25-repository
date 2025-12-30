package view;

import java.util.Arrays;

public class Ex06StringMutable {
	public static void main(String[] args) {
		String[] words = getWords("#$%^& Grid 562())) Layout. This is a type of layout in Java Swing languag");
		System.out.println("(words) --> " + Arrays.toString(words));
	}
	private static String[] getWords(String s) {
	    if (s == null || s.isBlank()) {
	        return new String[0];
	    }
	    
	    int count = 0;
	    String[] words = new String[s.length()];
//	    String word = ""; //immutable
	    StringBuilder word = new StringBuilder(); //mutable

	    for (int i = 0; i < s.length(); i++) {
	        char letter = s.charAt(i);

	        if (isLetter(letter)) {
	            word.append(letter);
	            System.out.println(System.identityHashCode(word));
	        } else {
	            if (!word.isEmpty()) {
	                words[count++] = word.toString();
	                word.delete(0, word.length()); //gán về rỗng
	            }
	        }
	    }

	    if (!word.isEmpty()) {
	        words[count++] = word.toString();
	    }

	    return Arrays.copyOfRange(words, 0, count);
	}
	private static boolean isInWord(int begin) {
	    return begin != -1;
	}
	private static boolean isLetter(char c) {
	    return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}
}
