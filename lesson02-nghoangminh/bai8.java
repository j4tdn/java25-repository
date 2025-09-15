package nghoangminh_lesson02exercise;

import java.util.Scanner;

public class bai8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = -1;
		int count = 0;

		while (count < 5) {
			System.out.print("Nhập số nguyên dương N: ");
			String input = scanner.nextLine();

			// kiểm tra có phải số nguyên dương không
			if (!input.matches("\\d+")) {
				System.out.println("Lỗi: N phải là số nguyên dương!");
				count++;
				continue;
			}

			N = Integer.parseInt(input);

			if (N < 2) {
				System.out.println("Lỗi: N phải >= 2!");
				count++;
				continue;
			}

			break; // nhập hợp lệ thì thoát vòng lặp
		}

		if (N >= 2) {
			System.out.println(N + (isPrime(N) ? " là số nguyên tố (true)" : " không phải số nguyên tố (false)"));
		} else {
			System.out.println("Bạn đã nhập sai quá 5 lần. Kết thúc chương trình!");
		}

		scanner.close();
	}

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
