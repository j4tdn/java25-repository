package ex04;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập phần tử trong mảng:");
		int n = sc.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println("a[" + i + "] = ");
			a[i] = sc.nextInt();
		}
		int tong = sum(a);
		System.out.println("Tổng các phần tử không trùng, bỏ lớn nhất và nhỏ nhất: " + tong);
	}

	static int sum(int[] a) {
		int min = a[0], max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min)
				min = a[i];
			if (a[i] > max)
				max = a[i];
		}
		int tong = 0;
		for (int i = 0; i < a.length; i++) {
			boolean trung = false;
			for (int j = 0; j < a.length; j++) {
				if (i != j && a[i] == a[j]) {
					trung = true;
					break;
				}
			}
			if (!trung && a[i] != min && a[i] != max) {
				tong += a[i];
			}

		}
		return tong;
	}
}
