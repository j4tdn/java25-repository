package exercise;

import java.util.Scanner;

public class Ex01FirstDegreeeQuation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = 0;
		double b = 0;
		
		while(true) {
			try {
				System.out.println("Nhập a: ");
				a = Double.parseDouble(sc.nextLine());
				
				System.out.println("Nhập b: ");
				b = Double.parseDouble(sc.nextLine());
				
				if(a == 0) {
					throw new ArithmeticException("lỗi: a = 0 --> không thể chia cho 0");
				}
				double x = -b / a;
				System.out.println("kết quả: x = " + x);
				break;
				
			}catch (NumberFormatException e) {
				System.out.println("sai kiểu dữ liệu");
			}catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
