package lesson3.assignments;

import java.util.Scanner;

import bean.Vehicle;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isRunning = true;
		Vehicle[] vehicles = null;
		int n = 0;
		while (isRunning) {
			System.out.println("================= VEHICLE MANAGEMENT =================");
			System.out.println("1 . Nhập thông tin và tạo N đối tượng xe");
			System.out.println("2 . Xuất bảng kê khai tiền thuế trước bạ của các xe.");
			System.out.println("3 . Thoát chương trình.");
			System.out.println("Nhap lua chon (1-3): ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				System.out.println("Nhập số lượng xe: ");
				n = Integer.parseInt(sc.nextLine());
				vehicles = new Vehicle[n];
				for (int i = 0; i < n; ++i) {
					vehicles[i] = inputVehicle(sc);
				}
				break;
			case 2:
				printVehicle(vehicles);
				break;
			case 3:
				isRunning = false;
				System.out.println("Bye bye");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Nhập 1-3.\n");
			}
		}
		sc.close();
	}

	private static Vehicle inputVehicle(Scanner sc) {
		System.out.println("Nhập tên chủ xe: ");
		String owner = sc.nextLine();
		System.out.println("Nhập loại xe: ");
		String vehicleType = sc.nextLine();
		System.out.println("Nhập dung tích: ");
		int capacity = Integer.parseInt(sc.nextLine());
		System.out.println("Nhập giá trị xe: ");
		double price = Double.parseDouble(sc.nextLine());
		return new Vehicle(owner, vehicleType, capacity, price);
	}

	private static void printVehicle(Vehicle[] vehicles) {
		System.out.printf("%-20s%20s%25s%30s%20s%n", "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá", "Thuế phải nộp");
		System.out.println("=".repeat(120));
		for (int i = 0; i < vehicles.length; ++i) {
			System.out.println(vehicles[i]);
		}
	}
}
