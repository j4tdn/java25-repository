package sorting.bubble;

import static util.PrintUtils.*;

public class Ex01BubbleSortIntLeft {

	public static void main(String[] args) {
		
		int[] numbers = {4, 2, 2, 5, 0,9,1};
		
		generate("0. DS phan tu", numbers);
		
		sortAcs(numbers);
		
		generate("1. SX tang dan", numbers);
		
		sortDecs(numbers);
		
		generate("2. SX giam dan", numbers);
	}
	
	
	
	/**
	 * SX tang dan
	 * So vong: sau moi vong tim dc phan tu lon nhat nam "ben trai"(noi bot)
	 * 
	 * Trong moi vong lap
	 * + elements[j]: phan tu dung truoc
	 * + elements[j+1]: phan tu dung sau
	 */
	private static void sortAcs(int[] elements) {
		for(int i = 0; i < elements.length; i++) {
			for(int j = elements.length - 1; j > i ; j--) {
				if(elements[j] < elements[j-1]) {
					swap(elements, j, j-1);
				}
			}
		}
	}
	
	/**
	 * SX giam dan
	 * So vong: sau moi vong tim dc phan tu lon nhat nam ben trai(noi bot)
	 * 
	 * Trong moi vong lap
	 * + elements[j]: phan tu dung truoc
	 * + elements[j+1]: phan tu dung sau
	 */
	private static void sortDecs(int[] elements) {
		for(int i = 0; i < elements.length; i++) {
			for(int j = elements.length - 1; j > i ; j--) {
				if(elements[j] > elements[j-1]) {
					swap(elements, j, j-1);
				}
			}
		}
	}
	
	private static void swap(int[] elements, int i, int j) {
		int temp = elements[j];
		elements[j] = elements[j+1];
		elements[j+1] = temp;
	}
	
}
