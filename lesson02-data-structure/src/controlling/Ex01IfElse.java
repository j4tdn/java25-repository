package controlling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.Random;
import java.util.Scanner;

public class Ex01IfElse {
	
	private static Random rd = new Random();
	
	public static void main(String[] args) {
		System.out.println("=== Bắt đầu chương trình ===");
		
		int val = rd.nextInt(5, 20);
		System.out.println("val = " + val);
		
		// val % 2 == 0 true/false expression		
		// boolean isEven = (val % 2 == 0);
		// if(isEven)  --> if(isEven == true)
		// if(!isEven) --> if(isEven == false) 
		
		if (isOdd(val)) {
			int currentYear = YearMonth.now().getYear();
			System.out.println("\nKết quả khi GTNN là số lẻ: " + (currentYear + val));
		}
		
		/*
		Câu 2
		------
		Nhập vào mật khẩu, kiểm tra độ dài của mật khẩu có hợp lệ hay không
		Nếu độ dài của mật khẩu >= 8 --> in ra mật khẩu hợp lệ
		Ngược lại --> in ra mật khẩu ko hợp lệ, vui lòng nhập lại
		*/
		
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập mật khẩu: ");
		String password = ip.nextLine();
		
		if (password.length() >= 8) {
			System.out.println("Mật khẩu hợp lệ");
		} else {
			System.out.println("Mật khẩu không hợp lệ");
		}
		
		ip.close();
		
		/*
		 Câu 3
		 ------
		 Random điểm trung bình(số thực) của học sinh [0.0, 10.0] phần thập phân có 1 chữ số
		 Nếu điểm mà
		 + [0, 5)   : Yếu
		 + [5, 6.5) : Trung Bình
		 + [6.5, 8) : Khá
		 + [8, 10]  : Giỏi
		 */
		
		double avgPoint = generatePoint();
		System.out.println("\nĐiểm trung bình: " + avgPoint);
		System.out.println("Học lực: " + getRank(avgPoint));
		
		System.out.println("\n=== Kết thúc chương trình ===");
	}
	
	private static String getRank(double point) {
		if (point < 5) {
			return "Yếu";
		}
		if (point < 6.5) {
			return "Trung Bình";
		}
		if (point < 8) {
			return "Khá";
		}
		return "Giỏi";
	}
	
	private static double generatePoint() {
		double avgPoint = rd.nextDouble(11);
		if (avgPoint > 10) {
			avgPoint = 10;
		}
		BigDecimal avgPointBd = BigDecimal.valueOf(avgPoint).setScale(1, RoundingMode.HALF_UP);
		return avgPointBd.doubleValue();
	}
	
	private static boolean isOdd(int number) {
		return number % 2 != 0;
	}
	
}