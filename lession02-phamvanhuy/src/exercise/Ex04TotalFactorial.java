package exercise;

import java.util.Random;

public class Ex04TotalFactorial {
	public static void main(String[] args) {
		Random rd = new Random();
		int a = rd.nextInt(10, 20);
		int b = rd.nextInt(10, 20);
		int c = rd.nextInt(10, 20);
		int d = rd.nextInt(10, 20);

		long S = Factorial(a) + Factorial(b) + Factorial(c) + Factorial(d);

		System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
		System.out.println("S = a! + b! + c! + d! = " + S);
	}

	private static long Factorial(int n) {
		long gt = 1;
		for (int i = 1; i <= n; i++) {
			gt *= i;
		}
		return gt;
	}
}
