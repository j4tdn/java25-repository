package ex01;

import java.util.Scanner;

public class FirstDegreeEquation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = 0;
		double b = 0;

		while (true) {
			try {
				System.out.println("Nhập hệ số a:");
				a = Double.parseDouble(sc.nextLine());

				System.out.println("Nhập hệ số b:");
				b = Double.parseDouble(sc.nextLine());

				if (a == 0) {
					System.out.println("Hệ số a = 0 → phương trình vô nghiệm hoặc vô số nghiệm. Vui lòng nhập lại!");
					continue;
				}

				break;

			} catch (NumberFormatException e) {
				System.out.println("Lỗi: Bạn phải nhập số, không được nhập chữ! Hãy nhập lại.");
			}
		}

		double x = tinh(a, b);
		System.out.println("Kết quả: x = " + x);

		sc.close();
	}

	private static double tinh(double a, double b) {
		return -b / a;
	}
}
