package nghoangminh_lesson02exercise;

import java.util.Scanner;

public class bai5 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String input;
		int N = 0;

		while (true) {
			System.out.print("Nhập số nguyên dương N: ");
			input = scanner.nextLine();

			if (!input.matches("\\d+")) { // nếu chứa ký tự không phải số
				System.out.println("Lỗi: N phải là số nguyên dương!");
				continue;
			}

			N = Integer.parseInt(input);

			if (N < 10) {
				System.out.println("Lỗi: N phải có ít nhất 2 chữ số!");
				continue;
			}

			break;
		}

		String strN = String.valueOf(N);
		String reversed = new StringBuilder(strN).reverse().toString();

		if (strN.equals(reversed)) {
			System.out.println(N + " là số đối xứng (true)");
		} else {
			System.out.println(N + " không phải số đối xứng (false)");
		}

		scanner.close();
	}

}
