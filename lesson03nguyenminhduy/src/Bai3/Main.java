package Bai3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập Số Hàng: ");
		int h = sc.nextInt();
		System.out.println("Nhập Số Cột: ");
		int c = sc.nextInt();

		int[][] a = new int[h][c];

		System.out.println("Nhập phần tử của mảng: ");
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < c; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		boolean tim = false;
		for (int i = 0; i < h; i++) {
			int n = a[i][0];
			int v = 0;
			for (int j = 1; j < c; j++) {
				if (a[i][j] < n) {
					n = a[i][j];
					v = j;
				}
			}
			boolean yenngua = true;
			for (int k = 0; k < h; k++) {
				if (a[k][v] > n) {
					yenngua = false;
					break;
				}
			}
			if (yenngua) {
				System.out.println("\n Tìm thấy phần tử yên ngựa " + n + "Tại hàng " + (i + 1) + ", cột" + (v + 1));
				tim = true;
			}
		}
		if (!tim) {
			System.out.println("\n KHông có phần tử yên ngựa trong mảng");
		}
		sc.close();
	}

}
