package sorting.bubble;

import static utils.PrintUtils.*;

import function.lambda.FloatComp;

public class Ex02BubbleSortFloat {

	public static void main(String[] args) {
		float[] numbers = { 4.2f, 2.8f, 2.2f, 2.6f, 0, 9.5f, 1 };

		generate("0. Danh sách các phần tử", numbers);
//		sortAsc(numbers, (n1, n2) -> {
//			return Float.compare(n1, n2);
//		});
		generate("1. Sắp xếp tăng dần", numbers);
	}

	private static void sortAsc(int[] elements, FloatComp floatComp) {
		for (int i = 0; i < elements.length; ++i) {
			for (int j = 0; j < elements.length - i - 1; ++j) {
				if (floatComp.compare(elements[j], elements[j+1]) > 0) {
					swap(elements, j, j + 1);
				}
			}
		}
	}
	
	
	private static void sortDesc(int[] elements) {
		for (int i = 0; i < elements.length; ++i) {
			for (int j = 0; j < elements.length - i - 1; ++j) {
				if (elements[j] < elements[j + 1]) {
					swap(elements, i, j);
				}
			}
		}
	}

	private static void swap(int[] elements, int i, int j) {
		int tmp = elements[j];
		elements[j] = elements[j + 1];
		elements[j + 1] = tmp;
	}
}
