package video_array;

import java.util.Arrays;
import java.util.Iterator;

public class Ex02Filter {
	public static void main(String[] args) {
		/*
		 1. Tim phan tu le trong so nguyen
		 	Input: Mang
		 	Output: Mang so le
		 */
		int[] numbers = {1,2,3,4,5,6};
		int[] oddNumbers = findOddNumbers(numbers);
		System.out.println(Arrays.toString(oddNumbers));
	}
	
	private static int[] findOddNumbers(int[] elements) {
		int count = 0;
		int[] oddElements = new int[elements.length];
		for(int element: elements) {
			if(element % 2 != 0) {
				oddElements[count] = element;
				count++;
			}
		}
		
		int[] result = new int[count];
		for(int i = 0; i < count; i++) {
			result[i] = oddElements[i];
		}
		return result;
	}
	
}
