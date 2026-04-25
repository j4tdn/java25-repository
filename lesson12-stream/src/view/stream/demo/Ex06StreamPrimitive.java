package view.stream.demo;

import java.util.Arrays;

public class Ex06StreamPrimitive {

	public static void main(String[] args) {
		
		int[] digits = {1,2,3,4};
		
		Arrays.stream(digits) // IntStream
			.sum();
		
	}
	
}
