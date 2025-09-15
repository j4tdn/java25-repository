package exercise;

import java.util.Scanner;

public class Ex03Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số nguyên dương n: ");
		int n = sc.nextInt();
		int gt = 1;
		if (n >= 0) {
			for (int i = 1; i <= n; i++) {
				gt *= i;
			}
			System.out.println(n + "! =" +gt);
		} else
			System.out.println("n phải là số nguyên dương");

	}

}
