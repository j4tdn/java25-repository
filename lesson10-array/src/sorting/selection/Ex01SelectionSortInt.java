package sorting.selection;

import static utils.PrintUtils.*;
import static utils.ArrayUtils.*;

import functional.IntComp;


public class Ex01SelectionSortInt {

	public static void main(String[] args) {
		
		int[] numbers = {4, 2, 2, 5, 0, 9, 1};
		
		generate("0. Danh sách các phần tử", numbers);
		
		sort(numbers, (n1, n2) -> {
			return n2 - n1;
		});
		
		generate("1. Sắp xếp tăng dần", numbers);
		
	}
	
	private static void sort(int[] elements, IntComp intComp) {
		for(int round = 0; round < elements.length - 1; round++) {
			int minIndex = round;
			for(int i = round + 1; i < elements.length; i++) {
				if(intComp.compare(elements[round], elements[minIndex]) > 0) {
					swap(elements, round, i);
				}
			}
		}
	}
	
}
