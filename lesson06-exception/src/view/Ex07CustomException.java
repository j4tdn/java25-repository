package view;

import exeption.CalculationException;

public class Ex07CustomException {
	
	public static void main(String[] args) {
		try {
		doAlllocation(0, 0);
		}catch(CalculationException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	private static void doAlllocation(int p1, int p2) {
		if(p1 + p2 <= 0) {
			throw new CalculationException();
		}
		System.out.println("Allcoacted Amount: " + (p1 * p2));
	}

}
