package view;

import java.text.DecimalFormat;

import bean.Vehicle;

public class Ex02VehicleApp {
	
	public static void main(String[] args) {
		Vehicle[] vehicles = mockData();
		
		System.out.printf("%-15s %-16s %-12s %-20s %-13s\n", "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá", "Thuế phải nộp");
		
		for (int i = 0 ; i < 78; i++) {
			System.out.print("-");
		}
		System.out.println();
		
		DecimalFormat df = new DecimalFormat("#,###.00");
		for(Vehicle vehicle: vehicles) {
			System.out.printf(
					"%-15s %-16s %-12s %-20s %-13s\n", 
					vehicle.getOwnerName(), 
					vehicle.getModel(), 
					vehicle.getCapacity(), 
					df.format(vehicle.getPrice()),
					df.format(vehicle.getTax())
			);
		}
	}
	
	private static Vehicle[] mockData() {
		return new Vehicle[] {
			new Vehicle("Nguyễn Văn A1", "Future Neo 125", 100,  35_000_000),
			new Vehicle("Lê Ngọc B2",    "Ford Ranger",    3000, 850_000_000),
			new Vehicle("Hồ Tấn C3",     "Landscape",      1500, 1_000_000_000)
		};
	}
	
}
