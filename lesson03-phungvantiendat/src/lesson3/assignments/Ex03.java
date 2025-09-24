package lesson3.assignments;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so hang cho ma tran: ");
		int m = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap so cot cho ma tran: ");
		int n = Integer.parseInt(sc.nextLine());

		int[][] a = new int[m][n];


		int minVal = 99;
		int maxVal = 0;
		int row = 0, col = 0;
		int cnt = 0;
		boolean isOk = true;

		System.out.println("Nhap ma tran: ");
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				a[i][j] = Integer.parseInt(sc.next());
			}
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if(a[i][j] < minVal) {
					minVal = a[i][j];
					row = i;
					col = j;
				}
				maxVal = a[row][col];
				for(int z = 0;z<m;++z) {
					if(a[row][col] > maxVal) {
						isOk = false;
					}
				}
			}
			if(isOk) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
}
