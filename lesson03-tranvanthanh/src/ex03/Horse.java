package ex03;

import java.util.Scanner;

public class Horse {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);

        System.out.print("Nhập số hàng (M): ");
        int m = ip.nextInt();
        System.out.print("Nhập số cột (N): ");
        int n = ip.nextInt();

        int[][] A = new int[m][n];

        System.out.println("Nhập ma trận " + m + "x" + n + " :");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = ip.nextInt();
            }
        }

        System.out.println("Ma trận vừa nhập:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", A[i][j]);
            }
            System.out.println();
        }

        boolean count = false;
        for (int i = 0; i < m; i++) {
            int min = A[i][0];
            int column = 0;
           //Tìm phần tử nhỏ nhất trong hàng rồi đem so sánh vs cột 
            for (int j = 1; j < n; j++) {
                if (A[i][j] < min) {
                    min = A[i][j];
                    column = j;
                }
            }

            boolean check = true;
            for (int k = 0; k < m; k++) {
                if (A[k][column] > min) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("Phần tử yên ngựa: A[" + i + "][" + column + "] = " + min);
                count = true;
            }
        }

        if (!count) {
            System.out.println("Ma trận không có phần tử yên ngựa!");
        }

        ip.close();
    }
}