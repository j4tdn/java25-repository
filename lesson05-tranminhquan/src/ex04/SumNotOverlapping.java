package ex04;

import java.util.Scanner;

public class SumNotOverlapping {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số phần tử của mảng: ");
		int n = sc.nextInt();
		int[] x = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println("x[" + i + "] =");
			x[i] = sc.nextInt();
		}
		// tìm số nhỏ nhất, lớn nhất
		int min = x[0];
		int max = x[0];
		for (int i = 1; i < n; i++) {
			if (x[i] < min) {
				min = x[i];
			}
			if (x[i] > max) {
				max = x[i];
			}
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			boolean trungnhau = false;
			for (int j = 0; j < i; j++) {
				if (x[j] == x[i]) {
					trungnhau = true;
				}
			}
			if (!trungnhau && x[i] != min && x[i] != max) {
				sum += x[i];
			}
		}
		System.out.println("Tổng = " + sum);
	}
}
