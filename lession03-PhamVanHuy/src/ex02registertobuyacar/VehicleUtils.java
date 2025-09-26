package ex02registertobuyacar;

public class VehicleUtils {
	
	public VehicleUtils() {
	}
	
	public static double tax(Vehicle vehicle) {
		if(vehicle.getCapacity() < 100) {
			return vehicle.getPrice() * 0.01;
		} else if (vehicle.getCapacity() <= 200) {
			return vehicle.getPrice() * 0.03;
		} else {
			return vehicle.getPrice() * 0.05;
		}
	}
}
