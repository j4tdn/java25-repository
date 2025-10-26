package homework5;

import java.util.Scanner;

public class SortByLevel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap so luong phan tu (3 <= n <= 20): ");
		int a = sc.nextInt();

		int[] arr = new int[a];

		System.out.println("Nhap mang so nguyen:");
		for (int i = 0; i < a; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < a - 1; i++) {
			for (int j = i + 1; j < a; j++) {
				if (getLevel(arr[i]) > getLevel(arr[j])) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println("Sap xep theo level tang dan:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	public static int getLevel(int number) {
		int count = 0;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				count++;
			}
		}
		return count;
	}
}
