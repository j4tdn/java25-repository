package exercises;

import java.util.Scanner;

public class Bai1 {
	
	public static void main(String[] args) {
		Bai1.run();
	}
	public static void run() {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int N ;

		while (count < 5) {
			System.out.print("Nhập số nguyên dương N: ");

			if (sc.hasNextInt()) {
				N = sc.nextInt();

				if (N > 0) {
					boolean result = true;

					while (N > 0) {
						if (N % 2 != 0) {
							result = false;
						}

						System.out.println("Result: " + result);
						return;
					}

				} else {
					System.out.println("N phải > 0. Nhập lại: ");
					count++;
				}
			} else {
				System.out.println("Nhập số nguyên(N>0): ");
				sc.next();
				count++;
			}
		}
		System.out.println("Sai quá 5 lần, dừng chương trình");
	}
}
