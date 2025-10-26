package ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so phan tu: ");
        int n = sc.nextInt();

        // DK
        if (n < 5 || n > 100) {
            System.out.println("So luong phan tu phai nam trong khoang 5 <= n <= 100");
            sc.close();
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap so thu " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        List<Integer> devide7 = new ArrayList<>();
        List<Integer> devide5 = new ArrayList<>();
        List<Integer> other = new ArrayList<>();

        // Duyệt số trong mảng
        for (int x : arr) {
            if (x % 7 == 0 && x % 5 != 0) {
            	devide7.add(x); 
            } else if (x % 5 == 0 && x % 7 != 0) {
            	devide5.add(x);
            } else {
            	other.add(x); 
            }
        }

        System.out.println("\n=== Ket qua ===");

        for (int i = 0; i < devide7.size(); i++) {
            System.out.print(devide7.get(i));
            if (i < devide7.size() - 1) System.out.print(", ");
        }

        System.out.print(" | ");

        for (int i = 0; i < other.size(); i++) {
            System.out.print(other.get(i));
            if (i < other.size() - 1) System.out.print(", ");
        }

        System.out.print(" | ");

        for (int i = 0; i < devide5.size(); i++) {
            System.out.print(devide5.get(i));
            if (i < devide5.size() - 1) System.out.print(", ");
        }
        sc.close();
    }
}
