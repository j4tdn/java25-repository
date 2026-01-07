package view;

import java.util.Arrays;

public class Ex02GetLargestNumbers {

	public static void main(String[] args) {
		System.out.println(getLargestNumbers("01a2b3456cde478"));
		String[] texts = {"01a2b3456cde478", "aa6b546c6e22h", "aa6b326c6e22h"};
		int[] sorted = new int[texts.length];
		for(int i = 0; i < sorted.length; i++) {
			sorted[i] = getLargestNumbers(texts[i]);
		}
		for(int i = 0; i < sorted.length - 1; i++) {
			for(int j = i + 1; j < sorted.length; j++) {
				if(sorted[j] < sorted[i]) {
					int temp = sorted[j];
					sorted[j] = sorted[i];
					sorted[i] = temp;
				}
			}
		}
		
		System.out.println("Mảng sau khi sắp xếp --> " 
				+ Arrays.toString(sorted));
	}
	
	private static int getLargestNumbers(String str) {
		String max = "";
		StringBuilder cur = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			if(letter >= '0' && letter <= '9') {
				cur.append(letter);
			} else {
				if(compareTwoStrs(cur.toString(), max) > 0) {
					max = cur.toString();
				}	
				cur.setLength(0);
			}
		}
		return max.isEmpty() ? 0 : Integer.parseInt(max);
	}
	
	private static int compareTwoStrs(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return s1.length() > s2.length() ? 1 : -1;
		}
		return s1.compareTo(s2);
	}
	
}
