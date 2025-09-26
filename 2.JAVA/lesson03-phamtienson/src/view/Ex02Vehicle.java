package view;

import java.util.Scanner;

import bean.Vehicle;

public class Ex02Vehicle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập số lượng xe: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin xe thứ " + (i + 1) + ":");
            System.out.print("Tên chủ xe: ");
            String ownerName = scanner.nextLine();
            System.out.print("Loại xe: ");
            String model = scanner.nextLine();
            System.out.print("Dung tích xi lanh: ");
            int engineCapacity = scanner.nextInt();
            System.out.print("Trị giá xe: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); 

            vehicles[i] = new Vehicle(ownerName, model, engineCapacity, price);
        }

        System.out.printf("%-20s %-15s %-10s %-15s %-15s%n", 
                          "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá", "Thuế phải nộp");
        System.out.println("=================================================================================");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        scanner.close();
    }
}