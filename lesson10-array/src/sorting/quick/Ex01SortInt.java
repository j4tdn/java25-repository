package sorting.quick;

import static util.PrintUtils.*;

import java.util.Arrays;

import bean.SortOder;
import function.IntComp;
import util.ArrayUtils;

import static util.ArrayUtils.*;

public class Ex01SortInt {

	public static void main(String[] args) {
		// Su dung ham sort co san cua java
		// Voi tung mang voi kich thuoc phu hop -> cho method sort tuong ung
		
		// SX mang nguyen thuy
		// --> Chi ho tro SX tang dan

		int[] numbers = { 4, 2, 8, 5, 0, 9, 1 };

		generate("0. DS phan tu", numbers);

		ArrayUtils.sort(numbers, SortOder.ASC);
		generate("1. SX tang dan", numbers);
		
		ArrayUtils.sort(numbers, SortOder.DESC);
		generate("2. SX giam dan", numbers);

	}
	
}
