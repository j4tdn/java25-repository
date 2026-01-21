package view;

import java.util.Arrays;

public class Ex03Operations {
	public static void main(String[] args) {
		// length: 5
		String[] seqs = {"k1", "T9", "Z5", "X2", "D7"};
		
		String[] s = add(seqs, "K25", 4);
		System.out.println(Arrays.toString(s));
		
		String[] s2 = delete(seqs, 3);
		System.out.println(Arrays.toString(s2));
		
	}
	private static String[] add(String[] s, String value, int index) {
		
		String[] result = new String[s.length + 1];
		for (int i = 0; i < s.length; i++) {
			result[i] = s[i];
		}
		result[index] = value;
		
		for (int i = index; i< s.length; i++) {
			result[i+1] = s[i];
		}
		return result;
		
		
	}
	private static String[] delete(String[] arr, int index) {
		String[] result = new String[arr.length - 1];
		for (int i = 0; i < index; i++) {
			result[i] = arr[i];
		}
		
		for (int i = index + 1; i < arr.length; i++) {
			result[i - 1] = arr[i];
		}
		return result;
	}
	

}
