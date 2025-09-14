package exercises;

import java.util.Scanner;

public class Bai8 {

	public static void main(String[] args) {
		Bai8.run();
	}

	public static void run() {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int n = 0;

		while (count < 5) {
			System.out.print("Nhập số nguyên dương N: ");

			if (sc.hasNextInt()) {
				n = sc.nextInt();

				if (n > 0) {

					if (soNT(n)) {
						System.out.println(n + " là số nguyên tố.");
					} else {
						System.out.println(n + " không phải số nguyên tố.");
					}
					return;
				} else {
					System.out.println("N phải > 0!");
					count++;
				}
			} else {
				System.out.println("Nhập số nguyên (N > 0).");
				sc.next();
				count++;
			}
		}
		System.out.println("Sai quá 5 lần, dừng chương trình");
	}

	public static boolean soNT(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
