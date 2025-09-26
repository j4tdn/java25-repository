package Bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng xe: ");
        int n = Integer.parseInt(scanner.nextLine());

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin xe thứ " + (i + 1));
            System.out.print("Tên chủ xe: ");
            String ownerName = scanner.nextLine();

            System.out.print("Loại xe: ");
            String vehicleType = scanner.nextLine();

            System.out.print("Dung tích xylanh (cc): ");
            int engineCapacity = Integer.parseInt(scanner.nextLine());

            System.out.print("Trị giá xe: ");
            double value = Double.parseDouble(scanner.nextLine());

            vehicles[i] = new Vehicle(ownerName, vehicleType, engineCapacity, value);
        }

        System.out.println("\nBẢNG KÊ KHAI TIỀN THUẾ TRƯỚC BẠ");
        System.out.printf("%-20s %-15s %-10s %-15s %-15s\n",
                "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá", "Thuế phải nộp");

        for (Vehicle v : vehicles) {
            v.printInfo();
        }

        System.out.println("\nChương trình kết thúc.");
        scanner.close();
    }
}