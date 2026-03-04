package utils;
import java.util.Arrays;

import bean.Item;
import bean.SortOrder;

public class ArrayUtils {
	private ArrayUtils() {
	}
	
	public static void swap(int[] elements, int i, int j) {
		int temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
	public static void swap(Item[] elements, int i, int j) {
		Item temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
	public static void reverse(int[] elements) {
		int length = elements.length;
		for (int i = 0; i < length/2; i++) {
			ArrayUtils.swap(elements, i, length-i-1);
			
		}
	}
	
	public static void sort(int[] elements) {
		Arrays.sort(elements);
	}
	
	public static void sort(int[] elements, SortOrder sortOrder) {
		Arrays.sort(elements);
		
		if (sortOrder == SortOrder.DESC) {
			reverse(elements);
		}
	}
}
