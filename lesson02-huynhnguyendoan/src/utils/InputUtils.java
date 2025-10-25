package utils;

import java.util.Scanner;

/**
 * Utility class(lớp tiện ích) hỗ trợ các hàm cho việc nhập xuất
 * 
 * Các hàm trong class util thường chỉ phụ thuộc vào tham số truyền vào hoặc logic của hàm
 * không phụ thuộc vào đối tượng đang gọi
 * 
 * Tất cả các hàm đều ko phụ thuộc vào đối tượng đang gọi(1 class mặc định vẫn có thể tạo ra
 * các đối tượng thông thường) --> việc tạo đối tượng chỉ làm tốn vùng nhớ, thừa
 * 
 * --> private constructor để ngăn ko cho tạo đối tượng
 * 
 */
public class InputUtils {

	private static Scanner ip = new Scanner(System.in);
	
	private InputUtils() {
	}
	
	public static Integer inputNumberWithMin(int minValueExcl, int maxFailedTime) {
		return inputNumber(minValueExcl, Integer.MAX_VALUE, maxFailedTime);
	}
	
	public static Integer inputNumberWithMax(int maxValueExcl, int maxFailedTime) {
		return inputNumber(Integer.MIN_VALUE, maxValueExcl, maxFailedTime);
	}

	// Xong lesson04 --> sử dụng strategy design pattern
	public static Integer inputNumber(int minValueExcl, int maxValueExcl, int maxFailedTime) {
		Integer n = null;
		String text = null;

		int wrongTimes = 0;
		do {
			System.out.printf("Enter N(N > %s): ", minValueExcl);
			text = ip.nextLine();
			if (isNumber(text)) {
				n = Integer.parseInt(text);
				if (n > minValueExcl && n < maxValueExcl) {
					break;
				}
			}
			if (++wrongTimes == maxFailedTime) {
				System.out.println(">> Wrong times exceed " + maxFailedTime + " time(s), quit program");
				return null;
			}
		} while (true);

		return n;
	}

	private static boolean isNumber(String text) {
		for (int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			if (!Character.isDigit(letter)) {
				return false;
			}
		}
		return true;
	}

}