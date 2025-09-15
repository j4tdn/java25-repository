package controlling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;

public class Ex01IfElse {
	private static Random rd = new Random();

	public static void main(String[] args) {
		System.out.println("=== Bắt đầu chương trình ===");

		// Câu 1

		int val = rd.nextInt(5, 20);
		System.out.println("val = " + val);

		if (isOdd(val)) {
			int currentYear = java.time.YearMonth.now().getYear();
			System.out.println("\nKết quả khi GTNN là số lẻ: " + (currentYear + val));
		}

		// Câu 2
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhập mật khẩu: ");
		String password = sc.nextLine();

		if (password.length() > 8) {
			System.out.println("Mật khẩu hợp lệ");
		} else {
			System.out.println("Mật khẩu không hợp lệ, vui lòng nhập lại");
		}

		System.out.println("\n=== Kết thúc chương trình ===");
		// Câu 3
		double avgPoint = generatePoint();
		System.out.println("\nĐiểm trung bình: " + avgPoint);

		System.out.println("Học lực: " + getRank(avgPoint));

		sc.close();
	}

	private static double generatePoint() {
		double avgPoint = rd.nextDouble(11);
		if (avgPoint > 10) {
			avgPoint = 10;
		}
		BigDecimal avgPointBd = BigDecimal.valueOf(avgPoint).setScale(1, RoundingMode.HALF_UP);
		return avgPointBd.doubleValue();
	}

	private static String getRank(double point) {
		if (point < 5) {
			return "Yếu";
		} else if (point < 6.5) {
			return "Trung Bình";
		} else if (point < 8) {
			return "Khá";
		} else {
			return "Giỏi";
		}
	}

	// Hàm kiểm tra số lẻ
	static boolean isOdd(int n) {
		return n % 2 != 0;
	}

}
