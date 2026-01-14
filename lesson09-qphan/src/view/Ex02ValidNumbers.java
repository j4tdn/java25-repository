package view;

import java.util.Arrays;

public class Ex02ValidNumbers {
	
	public static void main(String[] args) {
		System.out.println("Max Valid Numbers: " + Arrays.toString(findMaxNumbers("01a2b3456cde478", "aa6b546c6e22h", "aa6b326c6e22h")));
	}
	
	private static long[] findMaxNumbers(String ...sequences) {
		long[] numbers = new long[sequences.length];
		int counter = 0;
		for (String sequence: sequences) {
			numbers[counter++] = findMaxNumber(sequence);
		}
		return numbers;
	}
	
	private static long findMaxNumber(String s) {
		if (s == null || s.isBlank()) {
			return 0;
		}
		long max = 0;
		String[] tokens = s.split("[a-z]+");
		for (String token: tokens) {
			if (token.isEmpty()) {
				continue;
			}
			max = Math.max(max, Long.parseLong(token));
		}
		return max;
	}
}
