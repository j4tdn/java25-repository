package controlling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.Random;
import java.util.Scanner;

public class Ex01IfElse {
	private static Random rd = new Random();
	public static void main(String[] args) {
		
		System.out.println("Bat dau chuong trinh: ");
		Random rd= new Random();
		int val = rd.nextInt(5,20);
		
		System.out.println(" val : " +val);
		//val %2==0 : true/false expression
		
		//boolean IsEven = (val % 2==0);
		// if(IsEven) --> if(isEven ==true)
		// if(!IsEven) --> if(isEven ==false)
		if(isOdd(val)) {
			int currentYear = YearMonth.now().getYear();
			
			System.out.println("so le la: " + (currentYear+ val));
		}
		System.out.println("Nhap mat khau: ");
		Scanner ip = new Scanner(System.in);

		String pass = ip.nextLine();
		if (pass.length() >= 8) {
			System.out.println("MK hop le");
		} else {
			System.out.println("MK khong hop le, vui long nhap lai");
		}
		ip.close();
		
		double avgPoint = generatePoint();
		System.out.println("Diem hs la: " + avgPoint);
		String rank = getRank(avgPoint);

		System.out.println("Hoc luc HS: " + rank);
		System.out.println("Ket thuc chuong trinh");
	}

	private static String getRank(double point) {

		if (point < 5.0) {
			return " Yeu ";

		}
		if (6.5 > point) {
			return " Trung binh ";
		}
		if (point < 8) {
			return " Kha ";
		}
		return " Gioi ";

	}

	private static double generatePoint() {
		float avgPoint = rd.nextFloat(11);
		if (avgPoint > 10f) {
			avgPoint = 10f;
		}

		BigDecimal avgPointBd = BigDecimal.valueOf(avgPoint).setScale(1, RoundingMode.HALF_UP);
		return avgPointBd.doubleValue();
	}

	private static boolean isOdd(int number) {
		return number % 2 != 0;
	}
	
}












