package sorting.bubble;

import static utils.PrintUtils.generate;

import functional.FloatComp;

public class Ex02BubbleSortFloat {
	
	public static void main(String[] args) {
		float[] numbers = {4.2f, 2.8f, 2.2f, 2.6f, 0f, 9.5f, 1};
		
		generate("0. Danh sách các phần tử", numbers);
		
		sort(numbers, (n1, n2) -> {
			/*if (n1 > n2) {
				return 1;
			}
			return -1;*/
			return Float.compare(n1, n2);
		});
		
		generate("1. Sắp xếp tăng dần", numbers);
		
		sort(numbers, (n1, n2) -> {
			/*if (n1 < n2) {
				return 1;
			}
			return -1;*/
			return Float.compare(n2, n1);
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
	private static void sort(float[] elements, FloatComp floatComp) {
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements.length - i - 1; j++) {
				if (floatComp.compare(elements[j], elements[j+1]) > 0) {
					swap(elements, j, j+1);
				}
			}
		}
	}
	
	private static void swap(float[] elements, int i, int j) {
		float temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
}
