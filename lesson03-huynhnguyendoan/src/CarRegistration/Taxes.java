package CarRegistration;

public class Taxes {
	public static double getTaxes(Customer vehicle) {
		if (vehicle.getCylinder() < 100) {
			return vehicle.getValue() * 0.01;
		} else if (vehicle.getCylinder() <= 200) {
			return vehicle.getValue() * 0.03;
		} else {
			return vehicle.getValue() * 0.05;
		}
	}
}
