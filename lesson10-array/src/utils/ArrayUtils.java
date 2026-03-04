package utils;

import java.util.Arrays;

public class ArrayUtils {

	private ArrayUtils() {
		
	}
	
	public static void swap(int[] elements, int i, int j) {
		int temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
	public static void sort(int[] elements) {
		Arrays.sort(elements);
	}
	
}
