package controlling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.Random;
import java.util.Scanner;

public class Ex01IfElse {

	private static Random rd = new Random();

	public static void main(String[] args) {
		System.out.println("=== Bat dau chuong trinh ===");

		// ============= Bai 1 ===========
		int val = rd.nextInt(5, 20);

		System.out.println("Val = " + val);

		// val % 2 == 0 true / false expression

		boolean isEven = (val % 2 == 0);
		// if(isEven) --> if(isEven == true)
		// if(!isEven) --> if(isEven == false)

		if (isOdd(val)) {
			int currentYear = YearMonth.now().getYear();
			System.out.println("KQ ngau nhien la so chan: " + (currentYear + val));
		}

		// ============= Bai 2 ==========
		Scanner ip = new Scanner(System.in);

		System.out.print("Nhap mat khau: ");
		String pw = ip.nextLine();

		if (pw.length() >= 8) {
			System.out.println("MK hop le");
		} else
			System.out.println("MK khong hop le");

		// ========== Bai 3 =========
		double mark = generatePoint();
		System.out.println("Diem: " + mark);
		System.out.println("Hoc Luc: " + getRank(mark));

		System.out.println("=== Ket thuc chuong trinh ===");
	}

	private static String getRank(double point) {
		if (point < 5) {
			return "Yeu";
		}
		if (point < 6.5) {
			return "TBinh";
		}
		if (point < 8) {
			return "Kha";
		}
		return "Gioi";
	}

	private static double generatePoint() {
		float avgPoint = rd.nextFloat(11);
		if (avgPoint > 10) {
			avgPoint = 10;
		}
		BigDecimal mark1 = BigDecimal.valueOf(avgPoint).setScale(1, RoundingMode.HALF_UP);
		return mark1.doubleValue();
	}

	private static boolean isOdd(int number) {
		return number % 2 != 0;
	}
}
