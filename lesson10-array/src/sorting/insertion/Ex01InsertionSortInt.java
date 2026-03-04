package sorting.insertion;

import static util.PrintUtils.*;

import function.IntComp;

import static util.ArrayUtils.*;

public class Ex01InsertionSortInt {

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
		for(int round = 1; round < length; round++) {
			for(int i = 0; i < round; i++) {
				if(intComp.compare(elements[i], elements[round]) > 0) {
					swap(elements, i, round);
				}
			}
		}
	}
	
}
