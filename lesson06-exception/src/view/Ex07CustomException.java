package view;

import exception.CalculationException;

public class Ex07CustomException {
	
	public static void main(String[] args) {
		try {
			doAllocatin(0, 0);
		}catch(CalculationException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void doAllocatin(int p1,int p2) {
		if(p1 + p2 <=0 ) {
			throw new CalculationException("Invalid params for calculation");
		}
		System.out.println("Allocated amount: "+(p1*p2));
	}
	
}
