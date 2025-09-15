package homework;

import java.util.Random;

public class Homework4 {
	public static void main(String[] args) {
		Random rd = new Random();
		long a = rd.nextInt(10, 21);
		long b = rd.nextInt(10, 21);
		long c = rd.nextInt(10, 21);
		long d = rd.nextInt(10, 21);

		System.out.println(factorial(a)+factorial(b)+factorial(c)+factorial(d));

	}

	private static long factorial(long number) {
		long factorialNumber = 1;
		for (int i = 1; i <= number; i++) {
			factorialNumber *= i;
		}
		return factorialNumber;
	}
}
