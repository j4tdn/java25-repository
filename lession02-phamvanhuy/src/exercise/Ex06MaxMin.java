package exercise;

import java.util.Scanner;

public class Ex06MaxMin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = nhapSo("a", sc);
		int b = nhapSo("b", sc);
		int c = nhapSo("c", sc);
		int max = timMax(a, b, c);
		int min = timMin(a, b, c);
		System.out.println("Số lớn nhất là " + max);
		System.out.println("Số nhỏ nhất là " + min);
	}

	public static int nhapSo(String ten, Scanner sc) {
		int x;
		while (true) {
			System.out.print("Nhập " + ten + ": ");
			if (sc.hasNextInt()) {
				x = sc.nextInt();
				if (x >= 0 && x < 20) {
					return x;
				} else {
					System.out.println(ten + " phải trong khoảng [0,20), nhập lại");
				}
			} else {
				System.out.println("Sai, bạn phải nhập số nguyên");
				sc.next();
			}
		}
	}

	public static int timMax(int a, int b, int c) {
		if (a >= b && a >= c) {
			return a;
		} else if (b >= a && b >= c) {
			return b;
		} else {
			return c;
		}
	}

	public static int timMin(int a, int b, int c) {
		if (a <= b && a <= c) {
			return a;
		} else if (b <= a && b <= c) {
			return b;
		} else {
			return c;
		}
	}
}
