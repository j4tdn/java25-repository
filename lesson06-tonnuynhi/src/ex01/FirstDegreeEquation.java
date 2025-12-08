package ex01;

import java.util.Scanner;

public class FirstDegreeEquation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = 0;
		double b = 0;

		while (true) {
			try {
				System.out.print("Nhập hệ số a: ");
				a = Double.parseDouble(sc.nextLine());

				System.out.print("Nhập hệ số b: ");
				b = Double.parseDouble(sc.nextLine());

				double x = tinh(a, b);

				System.out.println("Kết quả: x = " + x);
				break;

			} catch (NumberFormatException e) {
				System.out.println("Lỗi: Bạn phải nhập số, không được nhập chữ! Hãy nhập lại.\n");
			} catch (ArithmeticException e) {
				System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.\n");
			}
		}

		sc.close();
	}

	private static double tinh(double a, double b) {
		if (a == 0) {
			throw new ArithmeticException("Hệ số a = 0 nên không thể chia cho 0.");
		}
		return -b / a;
	}
}
