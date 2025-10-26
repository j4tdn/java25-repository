package ex05;

import java.util.Scanner;

public class LevelSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter n (3 <= n <= 20): ");
		int n = sc.nextInt();

		int[] arr = new int[n];
		System.out.println("Enter " + n + " integers:");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (getLevel(arr[i]) > getLevel(arr[j])) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println("After sorting by level:");
		for (int x : arr) {
			System.out.print(x + " ");
		}
	}

	public static int getLevel(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				count++;
		}
		return count;
	}
}