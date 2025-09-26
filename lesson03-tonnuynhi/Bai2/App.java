package Bai2;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void exportTaxDeclaration(List<Vehicle> vehicleList) {
		System.out.println("\n---------------------------------------------------------------------------------------");
		System.out.printf("%-15s %-15s %15s %10s %15s\n", "Tên người sở hữu xe", "Loại xe", "Trị giá xe", "Dung tích xylanh",
				"Thuế trước bạ");
		System.out.println("---------------------------------------------------------------------------------------");

		for (Vehicle vehicle : vehicleList) {
			String owner = vehicle.getOwner();
			String type = vehicle.getType();
			double value = vehicle.getValue();
			int capacity = vehicle.getCapacity();
			double tax = vehicle.calculateTax();

			System.out.printf("%-15s %-15s %15.2f %10d %15.2f\n", owner, type, value, capacity, tax);
		}
		System.out.println("---------------------------------------------------------------------------------------");
	}

	public static void main(String[] args) {

		Vehicle v1 = new Vehicle("Nguyễn A", "Wave", 20000000, 97); // < 100cc => 1%
		Vehicle v2 = new Vehicle("Trần B", "Exciter", 50000000, 155); // 100cc-200cc => 3%
		Vehicle v3 = new Vehicle("Lê C", "Z1000", 400000000, 1000); // > 200cc => 5%

		List<Vehicle> vehicleList = new ArrayList<>();
		vehicleList.add(v1);
		vehicleList.add(v2);
		vehicleList.add(v3);

		exportTaxDeclaration(vehicleList);

	}
}