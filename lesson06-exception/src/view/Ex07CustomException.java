package view;

import exception.CalculationException;

public class Ex07CustomException {

	public static void main(String[] args) {
		try {
			doAllocation(0, 0);
		}catch(CalculationException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	private static void doAllocation(int p1, int p2) {
		if(p1 + p2 <= 0) {
			throw new CalculationException("Invalide");
		}
		System.out.println("Allocated Amount: " + (p1 * p2));
	}
}
