package lesson2.assignments;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		boolean isValid = false;
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while(!isValid) {
			System.out.println("Nhap n: ");
			try {
				n = Integer.parseInt(sc.nextLine());
				System.out.println(isPalindromeNumber(n));
				isValid = true;
			} catch (NumberFormatException e) {
				System.err.println("So ban nhap khong hop le vui long nhap lai");
			}
		}

	}

	public static boolean isPalindromeNumber(int n) {
		int k = n;
		int res = 0;
		while (n > 0) {
			res = res * 10 + n% 10;
			n/=10;
		}
		return k == res;
	}
}
