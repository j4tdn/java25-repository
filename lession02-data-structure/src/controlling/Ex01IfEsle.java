package controlling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.Random;
import java.util.Scanner;

public class Ex01IfEsle {

	private static Random rd = new Random();

	public static void main(String[] args) {

		int val = rd.nextInt(5, 20);
		System.out.println("val = " + val);
		// boolean isEven = (val % 2 == 0);
		// if(isEven) --> if(isEven == true)
		// if(!isEven) --> if(isEven == false)
		if (isOdd(val)) {
			int currentYear = YearMonth.now().getYear();
			System.out.println("kết quả khi GTNN là số chẵn: " + (currentYear + val));
		}

		// câu 2:
		Scanner ip = new Scanner(System.in);

		System.out.println("Nhập MK: ");
		String mk = ip.nextLine();

		if (mk.length() >= 8) {
			System.out.println("Mật khâu hợp lệ");
		} else {
			System.out.println("Mật khẩu không hợp lệ");
		}
		// câu 3
		double avgPoint = generatePonint();
		System.out.println("\nđiểm trung bình:" + avgPoint);
		System.out.println("học lực: " + getRank(avgPoint));

		System.out.println("\n=== kết thúc chương trình ===");
	}

	private static String getRank(double point) {
		if (point < 5) {
			return "yếu";
		} else if (point < 6.5) {
			return "trung bình";
		} else if (point < 8) {
			return "khá";
		}
		return "giỏi";
	}

	private static double generatePonint() {
		double avgPoint = rd.nextDouble(11);
		if (avgPoint > 10) {
			avgPoint = 10f;
		}
		BigDecimal avdPointBd = BigDecimal.valueOf(avgPoint).setScale(1, RoundingMode.HALF_UP);
		return avdPointBd.doubleValue();
	}

	private static boolean isOdd(int number) {
		return number % 2 != 0;
	}
}
