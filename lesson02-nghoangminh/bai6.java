package nghoangminh_lesson02exercise;

import java.util.Scanner;

public class bai6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int a = inputNumber(scanner, "a");
		int b = inputNumber(scanner, "b");
		int c = inputNumber(scanner, "c");

		int max = Math.max(a, Math.max(b, c));
		int min = Math.min(a, Math.min(b, c));

		System.out.println("Số lớn nhất là " + max);
		System.out.println("Số nhỏ nhất là " + min);

		scanner.close();
	}

	public static int inputNumber(Scanner scanner, String name) {
		int num;
		while (true) {
			System.out.print("Nhập " + name + " = ");
			String input = scanner.nextLine();

			if (!input.matches("\\d+")) {
				System.out.println("Lỗi: phải nhập số nguyên!");
				continue;
			}

			num = Integer.parseInt(input);

			if (num < 0 || num >= 20) {
				System.out.println("Lỗi: số phải trong khoảng [0,20)!");
				continue;
			}

			break;
		}
		return num;
	}

}
