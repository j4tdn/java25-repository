package test01;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex01MinFract {
	private static final Scanner ip = new Scanner(System.in);
	private static final DecimalFormat df = new DecimalFormat("#,###");
	
	/** Bài 1 (20đ):Viết chương trình nhập vào 1 số thực có phần thập phân khác 0. Yêu
		cầu nhập lại(tối đa 3 lần) nếu nhập sai
		Sau đó tìm phân số tối giản của số thập phân đó. Ví dụ
		▪ 0.1 → 1/10
		▪ 0.2 → 1/5
		▪ 0.04 → 1/25
		▪ 0.75 → 3/4
		▪ 1.5 → 3/2
		▪ 1256.2156
	 */
	
	public static void main(String[] args) {
		// double number = inputDecimalNummber();
		// System.out.println("---------------------");
		// System.out.println("Giá trị vừa nhập: " + number);
		
		double[] numbers = {0.1, 0.2, 0.04, 0.75, 1.5, 1256.2156};
		
		for (double number: numbers) {
			System.out.printf("Phân số tối giản của %s là %s\n", number, getMinFract(number));
		}
	}
	
	private static String format(double val) {
		return df.format(val);
	}
	
	private static String getMinFract(double number) {
		String numberAsText = String.valueOf(number);
		
		String[] parts = numberAsText.split("\\.");
		String intPart = parts[0];
		String decimalPart = parts[1];
		
		double numerator = Integer.parseInt(intPart) * Math.pow(10, decimalPart.length()) + Integer.parseInt(decimalPart);
		double denominator = Math.pow(10, decimalPart.length());
		
		double gcd = gcd(numerator, denominator);
		
		return format(numerator/gcd) + "/" + format(denominator/gcd);
	}
	
	// ước chung lớn nhất, greatest common multiple
	private static double gcd(double n1, double n2) {
		if (n1 == 0) return n2;
		if (n2 == 0) return n1;
		while(n1 != n2) {
			if (n1 > n2) {
				n1 -= n2;
			} else {
				n2 -= n1;
			}
		}
		return n1;
	}
	
	private static double inputDecimalNummber() {
		String text = "";
		int wrongTimes = 0;
		do {
			System.out.print("Nhập vào một số thập phân(ptp != 0): ");
			text = ip.nextLine();
			
			if (isDecimalNumberUsingRegex(text)) {
				break;
			}
			
			if(++wrongTimes == 3) {
				System.out.println("Số lần sai chạm mốc 3 lần. Thoát chương trình ...");
				System.exit(0);
			}
			
		} while (true);
		return Double.parseDouble(text);
	}
	
	// Cách 2: Dùng biểu thức chính quy
	// Số thực
	// Phần bên trái(là số): Ít nhất là 1 chữ số
	// Dấu .
	// Phần bên phải(là số): Ít nhất 1 chữ số
	private static boolean isDecimalNumberUsingRegex(String text) {
		if (text.matches("\\d+\\.\\d+")) {
			double val = Double.parseDouble(text);
			return Math.floor(val) != val;
		}
		
		return false;
	}
	
	// Cách 1: Dùng logic
	private static boolean isDecimalNumber(String text) {
		String[] parts = text.split("\\.");
		
		if (parts.length != 2) {
			return false;
		}
		
		String intPart = parts[0];
		String decimalPart = parts[1];
		
		return isNumber(intPart) && isNumber(decimalPart) && Integer.parseInt(decimalPart) > 0;
	}
	
	private static boolean isNumber(String text) {
		// return text.matches(\\d+);
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
}
