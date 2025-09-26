package ex02registertobuyacar;


import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choose;
		Vehicle[] dsXe = null;
		do {
			System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập thông tin N xe");
            System.out.println("2. Xuất bảng kê khai thuế");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choose = sc.nextInt();
            
            switch (choose) {
			case 1: 
				System.out.println("Nhập số lượng xe: ");
				int n = sc.nextInt();
				dsXe = new Vehicle[n];
				
				for(int i = 0; i < n; i++) {
					System.out.println("Xe thứ " + (i+1) +": ");
					System.out.println("Tên chủ xe: ");
					String name = sc.next();
					System.out.println("Loại xe: ");
					String type = sc.next();
					System.out.println("Dung tích (cc): ");
					int capacity = sc.nextInt();
					System.out.println("Trị giá: ");
					double price = sc.nextDouble();
					dsXe[i] = new Vehicle(name, type, capacity, price);
				}
				break;
			case 2:
				if (dsXe == null) {
                    System.out.println("Chưa có dữ liệu xe");
                } else {
                    System.out.printf("%-20s %-15s %-10s %-15s %-15s\n", "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá", "Thuế phải nộp");
                    System.out.println("--------------------------------------------------------------------------------");
                    for (Vehicle v : dsXe) {
                        System.out.printf("%-20s %-15s %-10d %-15.2f %-15.2f\n",v.getName(), v.getType(), v.getCapacity(),v.getPrice(), VehicleUtils.tax(v));
                    }
                }
                break;
			case 3:
				System.out.println("Thoát chương trình");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ");
			}
		} while (choose	 != 3);
	}
}