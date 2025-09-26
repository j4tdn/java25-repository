package ex03;

import java.util.Random;
import java.util.Scanner;

public class SaddlePoint {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Nhập số hàng M: ");
		int m = sc.nextInt();
		System.out.print("Nhập số Cột N: ");
		int n = sc.nextInt();

		int[][] a = new int[m][n];
		Random rd = new Random();

		System.out.println("Ma trận ngẫu nhiên được tạo ra: ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = rd.nextInt(99) + 1;
				System.out.printf("%4d", a[i][j]);
			}

			System.out.println();
		}

		boolean found = false;
		for (int i = 0; i < n; i++) {
			int minVal = a[i][0];
			int colIndex = 0;
			for (int j = 1; j < n; j++) {
				if (a[i][j] < minVal) {
					minVal = a[i][j];
					colIndex = j;
				}
			}
			boolean isSaddle = true;
			for(int k = 0; k < m; k++) {
				if(a[k][colIndex] > minVal) {
					isSaddle = false;
					break;
				}
			}
			
			if(isSaddle) {
				System.out.println("Phần tử yên ngựa: A[" + i + "][" + colIndex + "] = " + minVal );
				found = true;
			}
		}	
		if(!found) {
			System.out.println("Không có phần tử yên ngựa.");
		}
		sc.close();
	}

}
