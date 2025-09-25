package Bai2;

import java.util.Scanner;

public class App {
	static Vehicle[] vehicles;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. Nhap thong tin xe");
			System.out.println("2. Xuat ban ke khai");
			System.out.println("3. ket thuc");
			System.out.println("Nhap lua chon: ");
			int choice = Integer.parseInt(sc.nextLine());
			
			switch (choice) {
			case 1:
				input();
				break;
			case 2:
				 export();
                 break;
                 
			case 3:
				System.out.println("ket thuc");
				return;
			default:
				System.out.println("Nhap kh dungs");
				break;
			}
		}	
		
	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so lượng xe máy: ");
		n = Integer.parseInt(sc.nextLine());
		vehicles = new Vehicle[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Nhap Ten Chu Xe: ");
			String name = sc.nextLine();
			System.out.println("Nhap loai xe: ");
			String vehicleType = sc.nextLine();
			System.out.println("Nhap dung tich: ");
			int capacity = Integer.parseInt(sc.nextLine());
			System.out.println("Nhap gtri xe: ");
			double value = Double.parseDouble(sc.nextLine());

			vehicles[i] = new Vehicle(name, vehicleType, capacity, value);
		}

	}

	public static void export() {
		System.out.printf("%-20s %-15s %-10s %-15s %-15s\n",
                "Ten chu xe", "Loai xe", "Dung tich", "Tri gia", "Thue phai nop");
        System.out.println("-------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            double tax = TaxCalculation.calculate(vehicles[i]);
            System.out.printf("%-20s %-15s %-10d %-15.2f %-15.2f\n",
                    vehicles[i].getName(),
                    vehicles[i].getVehicleType(),
                    vehicles[i].getCapacity(),
                    vehicles[i].getValue(),
                    tax);
        }
	}

}
