package sorting.bubble;

import static utils.PrintUtils.*;

public class Ex01BubbleSortIntLeft {
	
	public static void main(String[] args) {
		int[] numbers = {4, 2, 2, 5, 0, 9, 1};
		
		generate("0. Danh sách các phần tử", numbers);
		
		sortAsc(numbers);
		
		generate("1. Sắp xếp tăng dần", numbers);
		
		sortDesc(numbers);
		
		generate("2. Sắp xếp giảm dần", numbers);
	}
	/**
	 * Sắp xếp tăng dần: sau mỗi vòng lặp đưa phần tử nhỏ nhất sang "bên trái"(nổi bọt)
	 * 
	 * Trong mỗi vòng lặp
	 * + elements[j]: phần tử đứng trước
	 * + elements[j+1]: phần tử đứng sau
	 */
	private static void sortAsc(int[] elements) {
		for (int i = 0; i < elements.length; i++) {
			for (int j = elements.length - 1; j > i; j--) {
				if (elements[j] < elements[j-1]) {
					swap(elements, j, j-1);
				}
			}
		}
	}
	/**
	 * Sắp xếp giảm dần: sau mỗi vòng lặp đưa phần lớn nhỏ nhất sang "bên trái"(nổi bọt)
	 * 
	 * Trong mỗi vòng lặp
	 * + elements[j]: phần tử đứng trước
	 * + elements[j+1]: phần tử đứng sau
	 */
	private static void sortDesc(int[] elements) {
		for (int i = 0; i < elements.length; i++) {
			for (int j = elements.length - 1; j > i; j--) {
				if (elements[j] > elements[j-1]) {
					swap(elements, j, j-1);
				}
			}
		}
	}	
	private static void swap(int[] elements, int i, int j) {
		int temp = elements[j];
		elements[j] = elements[j+1];
		elements[j + 1] = temp;
	}
}