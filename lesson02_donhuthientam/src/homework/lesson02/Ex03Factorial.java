package homework.lesson02;

import java.util.Scanner;

public class Ex03Factorial {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		System.out.println("Nhap N");
		int val = ip.nextInt();

		System.out.println(val + "! = " + isValid(val));
		ip.close();

	}

	private static int isValid(int number) {
		if (number == 0) {
			return 1;
		} else {
			return number * isValid(number - 1);
		}

	}

}
