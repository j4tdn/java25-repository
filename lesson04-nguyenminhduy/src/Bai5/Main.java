package Bai5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số phần tử n (3 <= n <= 20): ");
		int n = sc.nextInt();

		int[] arr = new int[n];
		System.out.println("Nhập" + n + "số nguyên: ");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (countDivisors(arr[i]) > countDivisors(arr[j])) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println("Level tăng dần: ");
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + " ");
		}
	}

	private static int countDivisors(int x) {
		int count = 0;
		for (int i = 1; i <= x; i++) {
			if (x % i == 0)
				count++;
		}
		return count;
	}

}
