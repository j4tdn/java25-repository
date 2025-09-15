package controlling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.Random;
import java.util.Scanner;

public class Ex01IfElse {
	private static Random rd = new Random();

	public static void main(String[] args) {
		System.out.println("=== bat dau chuong trinh ===");
		
		
		int val = rd.nextInt(5, 20);
		System.out.println("val = "+val);
		// val % 2 == 0 true/false expression
		// boolean isEven = (val % 2 ==0);
		// if(isEven) --> if(isEven ==true)
		// if(!isEven) --> if(isEven == false)

		if(isOdd(val)) {
			int currentYear = YearMonth.now().getYear();
			System.out.println("\n ket qua khi GTNN la so le: " + (currentYear +val));
		}

			System.out.println("\n ===ket thuc chuong trinh ===");

			Scanner ip = new Scanner(System.in);

			// nhập mật khẩu
			System.out.println("nhập mật khẩu: ");
			String password = ip.nextLine();

			// kiểm tra độ dài mật khẩu
			if (password.length() >= 8) {
				System.out.println("mật khẩu hợp lệ");
			} else {
				System.out.println("mật khẩu không hợp lệ");
			}
			ip.close();

			double avgPoint = 10.5;
			System.out.println("\nDiem trung binh: "+ avgPoint);
			String rank = getRank(avgPoint);
			
			System.out.println("hoc luc :" +rank);
		}
	

		private static boolean isOdd(int number) {
			return number % 2 != 0;
		}
	private static String getRank(double avgPoint) {
		String rank;
		if (avgPoint <5) {
			rank ="yeu";
		}
		else if (avgPoint >=5 && avgPoint <6.5) {
			rank ="trung binh";
		}
		else if (avgPoint <8) {
			rank ="Kha";
		}
		else {
			rank ="Gioi";
			
		}
		return rank;
		
	}
	
//	private static double generatePoint() {
//	double avgPoint = rd.nextDouble(11);
//	if (avgPoint >10f) {
//		avgPoint =10f;
//	}
//	BigDecimal avgPointBd = BigDecimal.valueOf(avgPoint).setScale(1,RoundingMode.HALF_UP);
//	return avgPointBd.doubleValue();
//	}
}
