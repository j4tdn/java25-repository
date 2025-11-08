package d1;

import java.util.Scanner;

public class IsSpecialNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so can kiem tra: ");
		int sNumber = sc.nextInt();
		if (isSpecialNumber(sNumber))
			System.out.println(sNumber + " la so dac biet");
		else {
			System.out.println(sNumber + " khong phai la so dac biet");
		}

	}

	public static boolean isSpecialNumber(int sNumber) {
		int sum = 0;
		for (int i = 1; sum < sNumber; i++) {
			sum += i;
			if (sum == sNumber) {
				return true;
			}
		}
		return false;
	}
}
