package view;

import java.util.Scanner;

import utils.MathUtils;

public class Ex03Factorial {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		System.out.print("Enter N: ");
		Integer n = Integer.parseInt(ip.nextLine());
		
		if (n != null) {
			Long f = MathUtils.fact(n);
			if (f == null) {
				System.out.println("Yêu cầu n >= 2");
			} else {
				System.out.printf("f(%s) = %s", n, f);
			}
		}
		ip.close();
	}
}