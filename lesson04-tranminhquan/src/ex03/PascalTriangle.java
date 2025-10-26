package ex03;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so hang cua tam giac Pascal: ");
        int n = sc.nextInt();

        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                	triangle[i][j] = 1;// h1c1, h2c2,... đường chéo =1 trong tgia và cột đầu tiên =1
                } else {
                    // tổng = ((h,c -1)+(h-1,c))
                	triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
                }

                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
