package homework;

import java.util.Scanner;

import bean.Vehicle;

public class Ex02TaxRate {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		Vehicle[] vehicles = new Vehicle[3];

		for (int i = 0; i < 3; i++) {
			System.out.println("===== Nhập thông tin xe thứ " + (i + 1) + " =====\n");
			System.out.println("TÊN CHỦ XE: ");
			String name = ip.nextLine();

			System.out.println("LOẠI XE: ");
			String model = ip.nextLine();

			System.out.print("DUNG TÍCH: \n");
			int capacity = Integer.parseInt(ip.nextLine());

			System.out.print("TRỊ GIÁ: \n");
			double price = ip.nextDouble();
			ip.nextLine();

			Vehicle vehicle = new Vehicle(name, model, capacity, price);

			vehicles[i] = vehicle;
		}

		System.out.printf("%-20s %-15s %-15s %-15s %-15s\n", "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá",
				"Thuế phải nộp");

		System.out.println("=================================================================================");

		for (Vehicle o : vehicles) {
			System.out.printf("%-20s %-15s %-15d %-15.2f %-15.2f\n", o.getName(), o.getModel(), o.getCapacity(),
					o.getPrice(), o.Tax());

		}
		ip.close();

	}

}