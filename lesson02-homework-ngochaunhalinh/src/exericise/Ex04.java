package exericise;

import java.util.Random;

public class Ex04 {
	public static void main(String[] args) {
		Random rd = new Random();
		int a = rd.nextInt(10, 20);
		int b = rd.nextInt(10, 20);
		int c = rd.nextInt(10, 20);
		int d = rd.nextInt(10, 20);
		
		int sum = sumFactorial(a) + sumFactorial(b) + sumFactorial(c) + sumFactorial(d);
		System.out.println("a: " + a + "b: " + b + "c: " + c + "d: " + d);
		System.out.println("tong so giai thua: " + sum);
	}
	private static int sumFactorial(int n) {
		int kq = 1;
		for(int i = n; i >= 1; i--) {
			kq  *= i;
		}
		return kq;
	}
}
