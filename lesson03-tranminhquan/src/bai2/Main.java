package bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng xe: ");
        int n = sc.nextInt();

        // khai báo mảng dsXe có các phần tử là n nhập từ b phím
        Vehicle[] dsXe = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin xe thứ " + (i + 1));
            System.out.print("Tên chủ xe: ");
            String ten = sc.nextLine();
            System.out.print("Loại xe: ");
            String loai = sc.nextLine();
            System.out.print("Trị giá xe: ");
            double gia = sc.nextDouble();
            System.out.print("Dung tích (cc): ");
            int dt = sc.nextInt();

            dsXe[i] = new Vehicle(ten, loai, gia, dt);
        }

        System.out.println("\n========== BẢNG KÊ KHAI TIỀN THUẾ ==========");
        // số kí tự cần in ra theo kdl(s, d, f, i...)
        // [-]: căn bên trái ra, k có gì tức căn phải
        System.out.printf("%-20s %-15s %-12s %-10s %-12s\n",
                "Tên chủ xe", "Loại xe", "Trị giá", "Dung tích", "Thuế");

        for (Vehicle v : dsXe) {
            v.xuatThongTin();
        }
        System.out.println("=============================================");
    }
}
