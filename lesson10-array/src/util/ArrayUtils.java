package util;

import java.util.Arrays;

import bean.SortOder;

public class ArrayUtils {

	public ArrayUtils() {

	}
	
	public static void swap(int[] elements, int i, int j) {
		int temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
	public static void reverse(int[] es) {
		for(int i = 0; i < es.length/2; i++) {
			ArrayUtils.swap(es, i, es.length - i - 1);
		}
	}
	
	public static void sort(int[] es, SortOder sortOder) {
		Arrays.sort(es);
		if(sortOder == SortOder.DESC) {
			reverse(es);
		}
	}
}
