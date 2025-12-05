package view;

import exception.CalculationException;

public class Ex07CustomException {
	public static void main(String[] args) {
		doAllocation(0, 0);
	}
	
	private static void doAllocation(int p1, int p2) {
		if(p1 + p2 <= 0) {
			throw new CalculationException();
		}
		
		System.out.println("Allocation: " + (p1 + p2));
	}
}
