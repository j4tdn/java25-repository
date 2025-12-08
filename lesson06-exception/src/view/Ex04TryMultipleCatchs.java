package view;

import java.util.Scanner;

public class Ex04TryMultipleCatchs {
	public static void main(String[] args) {

		Scanner ip = new Scanner(System.in);

		try {
			System.out.println("Nhập tử số ");
			int numerator = Integer.parseInt(ip.nextLine());

			System.out.println("Nhập mẫu số ");
			int denominator = Integer.parseInt(ip.nextLine());

			int result = numerator / denominator;

			System.out.println("Kết quả: " + result);

		} catch (ArithmeticException | IllegalArgumentException e) {
			System.out.println(">> " + e.getMessage());
			e.printStackTrace();
		}

		ip.close();

	}

}
