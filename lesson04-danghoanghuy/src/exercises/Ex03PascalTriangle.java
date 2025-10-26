package exercises;

import java.util.Scanner;

public class Ex03PascalTriangle {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap hang: ");
        
        int row = scanner.nextInt();
        scanner.close();

        PascalTriangle(row + 1);
    }

    public static void PascalTriangle(int row) {

        int[][] pascal = new int[row][];

        for(int n = 1; n < row; n++) {
            pascal[n] = new int[n + 1];

            pascal[n][0] = 1;
            pascal[n][n] = 1;

            for(int k = 1; k < n; k++) {
                pascal[n][k] = pascal[n - 1][k - 1] + pascal[n - 1][k];
            }
        }
        
        for(int n = 1; n < row; n++) {
			for(int k = 0; k <= n; k++) {
				System.out.print(pascal[n][k]+ " ");
			}
			System.out.println();
		}
    }
}
