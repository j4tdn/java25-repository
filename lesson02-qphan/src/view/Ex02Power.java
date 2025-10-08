package view;

import static utils.InputUtils.*;
import static java.lang.Math.*;

public class Ex02Power {
	
	public static void main(String[] args) {
		Integer n = inputNumberWithMin(0, 5);
		if (n != null) {
			System.out.printf("isPoweOf(%s, 2) --> %s", n, isPowerOf(n, 2));
		}
	}
	
	private static boolean isPowerOf(int n, int a) {
		double k = log(n) / log(a);
		return ceil(k) == floor(k);
	}
}
