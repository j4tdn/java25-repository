package ex03;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        int[][] pascal = new int[n][n];

        // Tạo tam giác Pascal
        for (int i = 0; i < n; i++) {
            pascal[i][0] = 1;       // phần tử đầu
            pascal[i][i] = 1;       // phần tử cuối

            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }

        // In ra tam giác Pascal (có căn giữa)
        for (int i = 0; i < n; i++) {
            // In khoảng trắng để căn giữa
            for (int s = 0; s < n - i - 1; s++) {
                System.out.print("  ");
            }

            // In giá trị của hàng i
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", pascal[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}