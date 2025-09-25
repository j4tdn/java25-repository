package Bai2;

public class TaxCalculation {
	
	private TaxCalculation() {
	}

	public static double calculate(Vehicle v) {
		int cc = v.getCapacity();
		double value = v.getValue();
		if (cc < 100) {
			return value * 0.01;
		} else if (cc <= 200) {
			return value * 0.03;
		} else {
			return value * 0.05;
		}

	}
}
