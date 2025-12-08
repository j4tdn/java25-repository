package view;

import java.util.Scanner;

public class Ex01Equation {
	public static void main(String[] args) {

		Scanner ip = new Scanner(System.in);

		System.out.println("Nhập A");
		int a = Integer.parseInt(ip.nextLine());

		System.out.println("Nhập B");
		int b = Integer.parseInt(ip.nextLine());

		try {
			System.out.println("Kết quả phương trình bật nhất ax + b = 0: " + Calc(a, b));
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

		ip.close();

	}

	private static int Calc(int a, int b) {
		if (a == 0) {
			throw new ArithmeticException("Vui lòng nhập tử số khác 0");
		}
		return -b / a;

	}

}
