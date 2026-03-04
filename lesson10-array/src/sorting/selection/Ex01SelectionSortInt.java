package sorting.selection;

import static utils.PrintUtils.*;

import functional.IntComp;

import static utils.ArrayUtils.*;

public class Ex01SelectionSortInt {

	public static void main(String[] args) {
		int[] numbers = { 4, 2, 8, 5, 0, 9, 1 };

		generate("0. Danh sách các phần tử", numbers);
		
		sort(numbers, (n1, n2) -> {
			return n1 - n2;
		});
		
		generate("1. Sắp xếp tăng dần", numbers);
		
		sort(numbers, (n1, n2) -> n2 - n1);
		
		generate("2. Sắp xếp giảm dần", numbers);
	}
	
	private static void sort(int[] elements, IntComp intComp) {
		int length = elements.length;
		for (int round = 0; round < length - 1; round++) {
			for (int i = round + 1; i < length; i++) {
				if (intComp.compare(elements[round], elements[i]) > 0) {
					swap(elements, round, i);
				}
			}
		}
	}

	/*
	private static void sort(int[] elements, IntComp intComp) {
		int length = elements.length;
		for (int round = 0; round < length - 1; round++) {
			int index = round;
			for (int i = round + 1; i < length; i++) {
				if (intComp.compare(elements[index], elements[i]) > 0) {
					index = i;
				}
			}
			if (index != round) {
				swap(elements, index, round);
			}
		}
	}
	*/
}
