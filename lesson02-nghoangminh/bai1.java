package nghoangminh_lesson02exercise;

import java.util.Scanner;

public class bai1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		boolean valid = false;

		// Nhập tối đa 5 lần
		for (int i = 0; i < 5; i++) {
			System.out.print("Nhập số nguyên dương N: ");
			String input = sc.nextLine();

			if (isPositiveInteger(input)) {
				N = Integer.parseInt(input);
				valid = true;
				break;
			} else {
				System.out.println("Dữ liệu không hợp lệ. Hãy nhập lại!");
			}
		}

		if (!valid) {
			System.out.println("Bạn đã nhập sai quá 5 lần. Kết thúc chương trình.");
		} else {
			// Kiểm tra bội của 2
			if (N % 2 == 0) {
				System.out.println(N + " là bội của 2 → true");
			} else {
				System.out.println(N + " không phải bội của 2 → false");
			}
		}

		sc.close();

	}

	public static boolean isPositiveInteger(String str) {
		if (str == null || str.isEmpty())
			return false;
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		int num = Integer.parseInt(str);
		return num > 0;

	}
}
