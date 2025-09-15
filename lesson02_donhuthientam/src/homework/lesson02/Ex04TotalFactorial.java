package homework.lesson02;

import java.util.Random;

public class Ex04TotalFactorial {
	public static void main(String[] args) {
		Random rd = new Random();

		int a = rd.nextInt(10, 20);
		int b = rd.nextInt(10, 20);
		int c = rd.nextInt(10, 20);
		int d = rd.nextInt(10, 20);

		int total = isvalid(a) + isvalid(b) + isvalid(c) + isvalid(d);
		System.out.println("total a! + b! + c! + d!: " + total);

	}

	private static int isvalid(int number) {
		if (number == 0) {
			return 1;
		} else {
			return number * isvalid(number - 1);
		}

	}

}
