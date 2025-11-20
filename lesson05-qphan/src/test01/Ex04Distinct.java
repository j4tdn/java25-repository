package test01;

import java.util.Arrays;

public class Ex04Distinct {

	public static void main(String[] args) {
		int[] numbers = { 1, 5, 8, 9, 2, 5, 9 };
		
		int[] elements = distinctAndSort(numbers);
		
		System.out.println("elements: " + Arrays.toString(elements));
		System.out.println("sum: " + sumExcludeMinMax(elements));
	}
	
	private static int sumExcludeMinMax(int[] elements) {
		int sum = 0;
		for (int i = 1; i < elements.length - 1; i++) {
			sum += elements[i];
		}
		return sum;
	}
	
	private static int[] distinctAndSort(int[] source) {
		// mảng để chứa các phần tử không trùng nhau
		int[] target = new int[source.length];
		int i = 0;
		
		for (int element: source) {
			if (!isExists(element, target, i)) {
				target[i++] = element;
			}
		}
		
		int[] result = Arrays.copyOfRange(target, 0, i);
		
		Arrays.sort(result);
		
		return result;
	}

	
	private static boolean isExists(int element, int[] target, int currentSize) {
		for (int i = 0; i < currentSize; i++) {
			if (element == target[i]) {
				return true;
			}
		}
		return false;
	}
}
