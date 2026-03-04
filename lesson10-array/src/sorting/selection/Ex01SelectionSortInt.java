package sorting.selection;

import static util.PrintUtils.*;

import function.IntComp;

import static util.ArrayUtils.*;

public class Ex01SelectionSortInt {

	public static void main(String[] args) {

		int[] numbers = { 4, 2, 8, 5, 0, 9, 1 };

		generate("0. DS phan tu", numbers);
		
		sort(numbers, (n1, n2) -> {
			return n1 - n2;
		});		
		generate("1. SX tang dan", numbers);
		
		sort(numbers, (n1, n2) -> {
			return n2 - n1;
		});		
		generate("2. SX giam dan", numbers);

	}

	private static void sort(int[] elements, IntComp intComp) {
		int length = elements.length;
		for(int round = 0; round < length; round++) {
			int index = round;
			for(int i = round + 1; i < length; i++) {
				if(intComp.compare(elements[index], elements[i]) > 0) {
					swap(elements, index, i);
				}
			}
		}
	}
	
}
