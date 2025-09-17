package exericise;

import java.util.Scanner;

public class Ex08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wrongTime = 0;
		int n = 0;
		do {
			System.out.println("Nhap so nguyen duong: ");
			if (!sc.hasNextInt()) {
				sc.next();
				System.out.println("Khong phai so nguyen");
				wrongTime++;
			} else {
			 n = sc.nextInt();
				 if (isCheck(n)) {
					System.out.println("day la so nguyen to");
					break;
				} else {
					System.out.println("kh ph so nguyen to");
					wrongTime++;
				}
			}
			if (wrongTime == 5) {
				System.out.println("Nhap qua 5 lan!");
				break;
			}
		} while (true);

	}

	private static boolean isCheck(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;

	}
}
