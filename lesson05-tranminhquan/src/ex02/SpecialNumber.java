package ex02;

import java.util.Scanner;

public class SpecialNumber {

	public static boolean isSpecialNumber(int n) {
		if ( n <= 0 )
			return false;
		int S = 0;
		for ( int i = 1; S < n; i++ ) {
			S += i;
		}
		return S == n;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập n: ");
		int n = sc.nextInt();
		if (isSpecialNumber(n)) {
			System.out.println("n là số đặc biệt");
		} else {
			System.out.println("n k phải là số đặc biệt");
		}
	}
}
