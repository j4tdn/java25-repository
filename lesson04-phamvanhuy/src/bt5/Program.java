package bt5;

import java.util.Scanner;

public class Program {

	public static int level(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập n (3 <= n <= 20): ");
		int n = sc.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("a[" + (i+1) + "] = ");
			a[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1 ; j < n; j++) {
				int I = level(a[i]);
				int J = level(a[j]);
				if(I > J || (I == J && a[i] > a[j])) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("Mảng sau khi sắp xếp:");
		for(int i = 0; i < n; i++) {
			System.out.println(a[i] + " ");
		}
	}
}
