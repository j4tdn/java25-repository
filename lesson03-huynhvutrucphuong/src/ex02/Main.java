package ex02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng xe: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Vehicle[] vhc = new Vehicle[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin xe thứ " + (i+1) + ":");

            System.out.print("Chủ sở hữu: ");
            String owner = sc.nextLine();

            System.out.print("Tên xe: ");
            String name = sc.nextLine();

            System.out.print("Trị giá xe: ");
            double value = sc.nextDouble();

            System.out.print("Dung tích xi lanh: ");
            int capacity = sc.nextInt();
            sc.nextLine(); 

            vhc[i] = new Vehicle(owner, name, value, capacity);
        }

        System.out.printf("%-15s %-15s %10s %10s %12s\n",
                "Chủ sở hữu", "Tên xe", "Trị giá", "Dung tích", "Thuế phải nộp");

        System.out.println("----------------------------------------------------------------------");

        for (Vehicle v : vhc) {
            System.out.println(v.toString());
        }

        sc.close();
    }
}
