package sorting.bubble;

import static utils.PrintUtils.*;

import functional.IntComp;

public class Ex01BubbleSortInt {
	
	public static void main(String[] args) {
		int[] numbers = {4, 2, 2, 5, 0, 9, 1};
		
		generate("0. Danh sách các phần tử", numbers);
		
		sort(numbers, (n1, n2) -> {
			return n1 - n2;
		});
		
		generate("1. Sắp xếp tăng dần", numbers);
		
		sort(numbers, (n1, n2) -> {
			return n2 - n1;
		});
		
		generate("2. Sắp xếp giảm dần", numbers);
	}
	
	
	/**
	 * Sắp xếp: sau mỗi vòng lặp đưa phần tử lớn/nhỏ nhất sang "bên phải"(nổi bọt)
	 * 
	 * Trong mỗi vòng lặp
	 * + elements[j]: phần tử đứng trước
	 * + elements[j+1]: phần tử đứng sau
	 */
	private static void sort(int[] elements, IntComp intComp) {
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements.length - i - 1; j++) {
				if (intComp.compare(elements[j], elements[j+1]) > 0) {
					swap(elements, j, j+1);
				}
			}
		}
	}
	
	private static void swap(int[] elements, int i, int j) {
		int temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
}
