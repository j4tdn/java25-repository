package view;

import java.util.Scanner;

public class SpecialNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("nhap so nguyen n : ");
		n = sc.nextInt();
		System.out.printf("%s co phai la so dac biet khong? --> %s", n, isSpecialNumber(n));
		
	}
	
	private static boolean isSpecialNumber(int n) {
		int sum = 0;
		for(int i = 1; sum < n; i++) {
			sum += i;
			
			if (sum == n) {
				return true;
			}
		}
		return false;
	}

}
