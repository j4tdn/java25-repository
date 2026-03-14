package sorting.insertion;

import static utils.PrintUtils.*;

import function.lambda.IntComp;

import static utils.ArrayUtils.*;


public class Ex01InsertionSortInt {

	public static void main(String[] args) {
		int[] numbers = { 4, 2, 8, 5, 0, 9, 1 };
		generate("0. Danh sách các phần tử", numbers);
		sort(numbers, (n1, n2) -> n1 - n2);
		generate("1. Sắp xếp tăng dần", numbers);
		sort(numbers, (n1, n2) -> n2 - n1);
		generate("2. Sắp xếp giảm dần", numbers);
	}


	
	private static void sort(int[] elements, IntComp intComp) {
		int length = elements.length;
		for(int round = 1;round < length ;++round) {
			for(int i = 0; i< round; ++i) {
				if(intComp.compare(elements[i], elements[round]) > 0) {
					swap(elements, round, i);
				}
			}
		}
	}

}
