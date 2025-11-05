package view;

import utils.InputUtils;

public class Ex01Multiple {

	public static void main(String[] args) {
		
		// boxing, unboxing, auto boxing, auto unboxing
		// đối với các KDL có sẵn của Java như int, double, long, char --> Integer, Double, Long, Character
		
		// int a = 5;     // luôn có giá trị
		// Integer b = null; // có thể có giá trị || null
		
		// 100% có thể ép kiểu từ int sang Integer
		
		// khi ép kiểu từ Integer sang int --> yêu cầu giá trị Integer phải != null
		
		// b = a; // ép từ int sang Integer --> autoboxing
		
		// a = b; // ép từ Integer về int --> autounboxing 
		
		Integer n = InputUtils.inputNumber("Enter N(N > 0): ", val -> val > 0, 5);
		if (n != null) {
			System.out.printf("--> is %s multiple of 2: %s", n, isEven(n));
		}
	}
	
	private static boolean isEven(int n) {
		return n % 2 == 0;
	}
	
}
