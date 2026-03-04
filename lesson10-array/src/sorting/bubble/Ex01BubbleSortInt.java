package sorting.bubble;

import static util.PrintUtils.*;

import function.IntComp;

public class Ex01BubbleSortInt {

	public static void main(String[] args) {
		
		int[] numbers = {4, 2, 2, 5, 0,9,1};
		
		generate("0. DS phan tu", numbers);
		
		sort(numbers, (n1, n2) -> n1 - n2);
		
		generate("1. SX tang dan", numbers);
		
		sort(numbers, (n1, n2) -> n2 - n1);
		
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
	private static void sort(int[] elements, IntComp intComp) {
		for(int i = 0; i < elements.length; i++) {
			for(int j = 0; j < elements.length - i - 1; j++) {
				if(intComp.compare(elements[j], elements[j+1]) > 0) {
					swap(elements, j, j+1);
				}
			}
		}
	}
	
	/**
	 * SX tang dan
	 * So vong: sau moi vong tim dc phan tu lon nhat nam "ben phai"(noi bot)
	 * 
	 * Trong moi vong lap
	 * + elements[j]: phan tu dung truoc
	 * + elements[j+1]: phan tu dung sau
	 */
	private static void sortAcs(int[] elements) {
		for(int i = 0; i < elements.length; i++) {
			for(int j = 0; j < elements.length - i - 1; j++) {
				if(elements[j] > elements[j+1]) {
					swap(elements, j, j+1);
				}
			}
		}
	}
	
	/**
	 * SX giam dan
	 * So vong: sau moi vong tim dc phan tu lon nhat nam ben phai(noi bot)
	 * 
	 * Trong moi vong lap
	 * + elements[j]: phan tu dung truoc
	 * + elements[j+1]: phan tu dung sau
	 */
	private static void sortDecs(int[] elements) {
		for(int i = 0; i < elements.length; i++) {
			for(int j = 0; j < elements.length - i - 1; j++) {
				if(elements[j] < elements[j+1]) {
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
