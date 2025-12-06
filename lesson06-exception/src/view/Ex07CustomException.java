package view;

import exception.CalculationException;

public class Ex07CustomException {
	public static void main(String[] args) {
		try {
			doAllocation(0, 0);
		} catch (Exception e) {
			System.err.println(e.getMessage()); 
		}
	}
	
	private static void doAllocation(int p1, int p2) {
		if(p1 + p2 <= 0) {
			throw new CalculationException();
		}
		System.out.println("Allocation amount: " + (p1 + p2));
	}

}
