package lesson2.assignments;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 1;
		int n = 0;
		while(cnt <= 5) {
			System.out.println("Nhap n: " + " lan thu: "+cnt);
			try {
				n = sc.nextInt();
				System.out.println(checkLuyThua(n));
				++cnt;
			} catch (Exception e) {
				System.err.println("So ban nhap khong hop le vui long nhap lai");
				sc.nextLine();
			}
		}
	}

	private static boolean checkLuyThua(int n) {
		if (n <= 0) {
			return false;
		}
		while (n > 0 && (n%2==0)) {
			n /= 2;
		}
		
		return n==1;
	}
}
