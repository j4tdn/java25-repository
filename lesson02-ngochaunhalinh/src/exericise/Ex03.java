package exericise;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so n: ");
		int n = sc.nextInt();
		System.out.println("giai thua cua n la: " + isFactorial(n));
	}
	private static int isFactorial(int n) {
		int kq = 1;
		for(int i = n; i >= 1; i--) {
			kq  *= i;
		}
		return kq;
	}	
}
