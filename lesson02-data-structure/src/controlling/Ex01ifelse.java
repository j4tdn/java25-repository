package controlling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.Random;
import java.util.Scanner;

public class Ex01ifelse {

	private static Random rd = new Random();

	public static void main(String[] args) {
		System.out.println("=== bat dau =====");

		// Cau 1:

		int val = rd.nextInt(5, 20);
		System.out.println("val = " + val);

		if (isOdd(val)) {
			int currenYear = YearMonth.now().getYear();
			System.out.println("ket qua khi gtri so chan + nam hien tai: " + (currenYear + val));

		}

		// Cau 2:
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap mk: ");
		String mk = sc.nextLine();

		if (mk.length() >= 8) {
			System.out.println("mk dung");
		} else {
			System.out.println("nhap laij");
		}

		// Cau 3:

		double diem = generatePoint();
		System.out.println("Diem = " + diem);
		System.out.println("hoc luc: " + getRank(diem));
		


		System.out.println("=== ket thuc =====");
	}
	
	private static String getRank(double point) {
		
		if(point < 5) {
			return "Yeu";
		} if( point < 6.5) {
			return"trung binh";
		}if(point < 8) {
			return "kha";
		}
		return "gioi";
		
	}

	private static double generatePoint() {
		double diem = rd.nextDouble(11);
		if (diem > 10) {
			diem = 10;
		}
		BigDecimal diemBd = BigDecimal.valueOf(diem).setScale(1, RoundingMode.HALF_UP);
		return diemBd.doubleValue();
	}

	private static boolean isOdd(int number) {
		return number % 2 != 0;
	}

}
