package sorting.bubble;

import java.util.Arrays;

public class Ex01BubbleSortInt {

	public static void main(String[] args) {
		
		int[] nums = {4, 2, 2, 5, 0, 9, 1};
		
		sortAsc(nums);
		
		System.out.println(Arrays.toString(nums));
		
		sortDesc(nums);
		
		System.out.println(Arrays.toString(nums));
		
	}
	
	private static void sortAsc(int[] elements) {
		for(int i = 0; i < elements.length; i++) {
			for(int j = 0; j < elements.length - i - 1; j++) {
				if(elements[j] > elements[j + 1]) {
					swap(elements, i, j);
				}
			}
		}
	}
	
	private static void sortDesc(int[] elements) {
		for(int i = 0; i < elements.length; i++) {
			for(int j = 0; j < elements.length - i - 1; j++) {
				if(elements[j] < elements[j + 1]) {
					swap(elements, i, j);
				}
			}
		}
	}
	
	private static void swap(int[] elements, int i, int j) {
		int temp = elements[j];
		elements[j] = elements[j + 1];
		elements[j + 1] = temp;
	}
	
}
