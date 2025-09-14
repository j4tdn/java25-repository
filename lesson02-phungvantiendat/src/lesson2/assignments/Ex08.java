package lesson2.assignments;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 1;
		while(cnt <= 5) {
			System.out.println("Nhap n: ");
			try {
				int n = Integer.parseInt(sc.nextLine());
				System.out.println(isPrimeNumber(n));
				++cnt;
			} catch (NumberFormatException	 e) {
				System.err.println("So ban nhap khong hop le vui long nhap lai");
			}
		}
	}

	private static boolean isPrimeNumber(int n) {
		for (int i = 2; i <= (int) Math.sqrt(n); ++i) {
			if (n % i == 0) {
				return false;
			}
		}
		return n > 1;
	}
}
