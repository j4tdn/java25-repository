package lesson3.assignments;

import bean.Vehicle;

public class VehicleUtils {
	public static double taxCalculation(Vehicle vehicle) {
		if(vehicle.getCapacity() < 100) {
			return 0.01 * vehicle.getPrice();
		}else if(vehicle.getCapacity() >= 100 && vehicle.getCapacity() < 200) {
			return 0.03 * vehicle.getPrice();
		}else {
			return 0.05 * vehicle.getPrice();
		}
	}
}
