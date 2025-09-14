package Exercise;

import java.util.Scanner;

public class Ex01MultipleOfTwo {

	public static void main(String[] args) {

		/*
		 * BT1: Bài: Kiểm tra số nguyên dương N có phải là bội của 2 hay không. Yêu cầu
		 * nhập N từ bàn phím; nếu không hợp lệ thì bắt buộc nhập lại (tối đa 5 lần). Ví
		 * dụ hợp lệ: 4 -> true, 6 -> true, 7 -> false Ví dụ không hợp lệ: "abc" -> báo
		 * lỗi, yêu cầu nhập lại.
		 */

		Scanner scanner = new Scanner(System.in);

		int n = readPossitiveInt(scanner, 5); // đọc N ( max là 5 )

		if (n == -1) { // -1 mean nhập sai nhiều hơn số lần cho phép, thì sẽ trả về số này, và main sẽ
						// call dừng ctrinh khi thấy.

			System.out.println(" Bạn đã nhập sai quá số lần cho phép, chương trình kết thúc");
			return;
		}

		boolean result = isMultipleOfTwo(n);

		System.out.println(result); // in ra kết quả true/false.

		scanner.close(); // đóng việc nhập dữ liệu lại, tránh lỗi IllegalStateException.

	}

	// Hàm kiểm tra xem n có phải bội của 2 với n là số nguyên dương, n chia hết cho
	// 2 thì trả true, other false.
	private static boolean isMultipleOfTwo(int n) {
		return n % 2 == 0;
	}

	private static int readPossitiveInt(Scanner scanner, int maxAttempts) {
		for (int attempt = 1; attempt <= maxAttempts; attempt++) {
			System.out.println(" Nhập N(số nguyên dương):");

			// nhập 1 chuỗi vào, sau đó xóa khoảng trắng ở 2 đầu nếu k sẽ bị lỗi khi đưa
			// trực tiếp vào Interger.parseInt với khoảng trắng.
			String line = scanner.nextLine().trim();

			try {
				// nhập kí tự không phải số sẽ khiến ctrinh báo NumberFormatException, nghĩa là
				// không thể chuyển chuỗi này sang số đc
				// sai yêu cầu của đề > báo.
				int value = Integer.parseInt(line);
				if (value > 0) {
					return value; // giá trị lớn hơn 0 > đún yêu cầu, trả về giá trị.
					
				} else { // in ra số lần nhập sai.
					System.out.println(" Lỗi: N cần phải là số nguyên dương lớn hơn 0, vui lòng nhập lại." + "("
							+ attempt + "/" + maxAttempts + ")");
				}
			} catch (NumberFormatException ex) {
				System.out.println(
						"Lỗi: không phải số nguyên, vui lòng nhập lại." + " (" + attempt + "/" + maxAttempts + ")");
			}

		}

		return -1; // nhập sai 5 lần, trả về giá trị báo quá số lần nhập.
	}

}
