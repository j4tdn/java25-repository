package sorting.bubble;

import static util.PrintUtils.*;

import function.FloatComp;

public class Ex02BubbleSortFloat {

	public static void main(String[] args) {
		
		float[] numbers = {4.2f, 2.8f, 2.2f, 2.6f, 0, 9.5f ,1};
		
		generate("0. DS phan tu", numbers);
		
		sort(numbers, (n1, n2) -> {
//			if(n1 > n2) {
//				return 1;
//			}
//			return -1;
			return Float.compare(n1, n2);
		});
		
		generate("1. SX tang dan", numbers);
		
		sort(numbers, (n1, n2) -> {
//			if(n1 < n2) {
//				return 1;
//			}
//			return -1;
			return Float.compare(n2, n1);
		});
		
		generate("2. SX giam dan", numbers);
	}
	
	/**
	 *
	 * So vong: sau moi vong tim dc phan tu lon nhat nam "ben phai"(noi bot)
	 * 
	 * Trong moi vong lap
	 * + elements[j]: phan tu dung truoc
	 * + elements[j+1]: phan tu dung sau
	 */
	private static void sort(float[] elements, FloatComp floatComp) {
		for(int i = 0; i < elements.length; i++) {
			for(int j = 0; j < elements.length - i - 1; j++) {
				if(floatComp.compare(elements[j], elements[j+1]) > 0) {
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
