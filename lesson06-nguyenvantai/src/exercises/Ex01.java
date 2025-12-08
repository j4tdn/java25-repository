package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.printf("Nhập a: ");
		double a = inputA();
		sc.nextLine();
		System.out.printf("Nhập b: ");
		double b = inputNumber();

		double x = solveLinearEquation(a, b);

		System.out.println("Kết quả: x = " + x);
	}

	public static double inputNumber() {
		while (true) {
			try {

				return sc.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Lỗi: phải nhập số (không phải chữ)!");
				sc.nextLine();
			}
		}
	}

	public static double inputA() {
		double a;
		while (true) {
			a = inputNumber();
			if (a == 0) {
				System.out.println("Lỗi: a không được = 0 (chia cho 0).");
			} else {
				return a;
			}
		}
	}

	public static double solveLinearEquation(double a, double b) {
		return -b / a;
	}
}
