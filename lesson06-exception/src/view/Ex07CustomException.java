package view;

import exception.CalculationException;

public class Ex07CustomException {

	public static void main(String[] args) {
		try {
			doAllocation(0,0);
		} catch (CalculationException e) {
		System.err.println(e.getMessage());
		}
	}
	
	private static void doAllocation(int p1, int p2) {
		if(p1+p2>100) {
			throw new CalculationException("Invalid params for calcution");		
		}
		System.out.println("llocated Amount: "+(p1*p2));
	}
	
}
