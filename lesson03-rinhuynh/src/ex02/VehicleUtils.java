package ex02;
import java.util.Scanner;

public class VehicleUtils {
	public VehicleUtils() {
	}
	
	public static double calculateTax(Vehicle v) {
		int cc = v.getCapacity();
		double value = v.getValue();
		
		return cc < 100? value * 0.01 : ( cc <= 200 ? value * 0.03 : value * 0.05);
		
		
	}
    public static Vehicle inputVehicle(Scanner sc) {
        System.out.print("Tên chủ xe: ");
        String ownerName = sc.nextLine();

        System.out.print("Loại xe: ");
        String type = sc.nextLine();

        System.out.print("Dung tích (cc): ");
        int capacity = sc.nextInt();

        System.out.print("Trị giá: ");
        double value = sc.nextDouble();
        sc.nextLine();

        return new Vehicle(ownerName, type, capacity, value);
    }
    
    public static void exportHeader() {
        System.out.printf("%-20s %-15s %-10s %-15s %-15s\n",
                "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá", "Thuế phải nộp");
        System.out.println("==============================================================================");
    }
	
	public static void export(Vehicle v) {

		System.out.printf("%-20s %-15s %-10s %-15s %-15s\n",
				v.getOwnerName(), v.getType(), v.getCapacity(),
				v.getValue(), calculateTax(v));
		
	}
	
	

}
