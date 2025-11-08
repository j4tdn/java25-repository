package lesson02;

import java.util.Scanner;

public class SpeciaNumber {
	public static void main(String[] args) {

		Scanner ip = new Scanner(System.in);

		System.out.println("NHAP N");
		int num = ip.nextInt();

		System.out.println(num + " -> " + isSpecialNumber(num));

		ip.close();

	}

	private static boolean isSpecialNumber(int number) {
		if (number <= 0) {
			return false;
		}

		int n = 0;
		for (int i = 0; n < number; i++) {
			n += i;
			if (n == number) {
				return true;
			}

		}
		return false;

	}
}
