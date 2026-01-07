package utils;

public class ReverseString {
	public static String revert(String s) {
		s= s.trim().replaceAll("\\s+"," ");
		String[] words = s.split(" ");
		StringBuilder result = new StringBuilder();
		
		for(String word : words) {
			String reverseWord = new StringBuilder(word).reverse().toString();
			result.append(reverseWord).append(" ");
		}
		return result.toString().trim();
	}
}
