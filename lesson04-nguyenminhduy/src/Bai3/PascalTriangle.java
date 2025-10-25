package Bai3;

import java.util.Scanner;

public class PascalTriangle {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập số hàng của tam giác: ");
		int n = sc.nextInt();
		
		int[][] pascal = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			pascal[i][0] = 1;
			pascal[i][i] = 1;
			
			for(int j = 1; j < i; j++) {
				pascal[i][j] = pascal[i-1][j-1] + pascal[i - 1][j];
			}
		}
		
		System.out.println("====== Tam Giác Pascal ======");
		for(int i = 0; i < n; i++) {
			for(int space = n - i; space > 0; space--) {
				System.out.print(" ");
			}
			for(int j = 0; j<= i; j++) {
				System.out.print(pascal[i][j] + " ");
			}
			System.out.println();
		}
	}

}
