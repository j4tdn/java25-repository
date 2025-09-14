package lesson2.assignments;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n: ");
		int n = sc.nextInt();
		System.out.println(n + " giai thua = "+giaiThua(n));
	}
	
	private static long giaiThua(int n) {
		long res = 1;
		for(int i = 1;i<=n;++i) {
			res *= i;
		}
		return res;
	}
}
