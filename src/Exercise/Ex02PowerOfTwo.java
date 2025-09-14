package Exercise;

import java.util.Scanner;

public class Ex02PowerOfTwo {

	public static void main(String[] args) {

		/*
		 * Bài 2: Kiểm tra số nguyên dương N có phải là lũy thừa của 2 hay không. - Nhập
		 * N từ bàn phím (bắt buộc phải nhập số nguyên dương) - Nếu nhập sai thì yêu cầu
		 * nhập lại, tối đa 5 lần - Nếu quá 5 lần vẫn sai -> dừng chương trình - Ví dụ:
		 * 4 -> true, 6 -> false, 8 -> true, 9 -> false
		 */

		Scanner scanner = new Scanner(System.in);

		// Gọi hàm đọc số nguyên dương với tối đa 5 lần nhập
		int n = readPositiveInt(scanner, 5);

		if (n == -1) {
			// Nếu trả về -1 nghĩa là đã nhập sai quá số lần cho phép
			System.out.println("Bạn đã nhập sai quá nhiều lần. Chương trình dừng!");
		} else {
			// Kiểm tra xem N có phải là lũy thừa của 2 không
			boolean result = isPowerOfTwo(n);
			System.out.println(n + " có phải là lũy thừa của 2 không? " + result);
		}

		scanner.close();
	}

	// Hàm đọc số nguyên dương từ bàn phím (tối đa maxTries lần)
	private static int readPositiveInt(Scanner scanner, int maxTries) {
		int count = 0;

		while (count < maxTries) {
			System.out.print("Nhập số nguyên dương N: ");
			String input = scanner.nextLine().trim();

			try {
				int n = Integer.parseInt(input); // Chuyển chuỗi thành số nguyên
				if (n > 0) {
					return n; // Hợp lệ -> trả về kết quả
				} else {
					System.out.println("N phải là số nguyên dương! Hãy nhập lại.");
				}
			} catch (NumberFormatException e) {
				// Nếu nhập không phải số thì báo lỗi.
				System.out.println("Dữ liệu không hợp lệ! Hãy nhập lại.");
			}

			count++;
		}

		// Nếu nhập sai quá maxTries lần thì trả về -1
		return -1;
	}

	// Hàm kiểm tra số có phải là lũy thừa của 2 hay không
	private static boolean isPowerOfTwo(int n) {
		/*
		  - Một số là lũy thừa của 2 nếu ta liên tục chia 2 cho tới khi còn lại 1. 
		  - Nếu trong quá trình chia xuất hiện số lẻ (không chia hết cho 2) -> false 
		 */
		if (n <= 0)
			return false;

		while (n > 1) {
			if (n % 2 != 0) { // Nếu gặp số lẻ (không chia hết cho 2)
				return false;
			}
			n = n / 2; // Chia đôi tiếp
		}

		return true; // Nếu cuối cùng còn lại 1 thì đúng
	}
}
