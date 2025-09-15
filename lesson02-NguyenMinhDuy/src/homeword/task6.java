package homeword;

import java.util.Scanner;

/**
 * Bài 6: Viết chương trình tìm số nguyên lớn, nhỏ nhất trong 3 chữ số a,b,c
 * Biết rằng a,b,c là số nguyên được nhập từ bàn phiasm và nhỏ hơn 20 [0, 20)
 * VD: Nhập a = 6 Nhập b = “xyz” → báo lỗi, yêu cầu nhập lại Nhập b = 12 Nhập c
 * = 8 Số lớn nhất là 12 Số nhỏ nhất là 6
 */
public class task6 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int a, b, c;
		int wrongtimes = 0;
		do {
			System.out.println("Nhập vào 1 số NGUYÊN DƯƠNG a < 20: ");
			a = ip.nextInt();
			if (nhap(a)) {
				break;
			}
			System.out.println(" phải là số NGUYÊN DƯƠNG vui lòng nhập lại !");
		} while (true);

		do {
			System.out.println("\nNhập vào 1 số NGUYÊN DƯƠNG b < 20: ");
			b = ip.nextInt();
			if (nhap(b)) {
				break;
			}
			System.out.println(" phải là số NGUYÊN DƯƠNG vui lòng nhập lại !");
		} while (true);

		do {
			System.out.println("\nNhập vào 1 số NGUYÊN DƯƠNG c< 20: ");
			c = ip.nextInt();
			if (nhap(c)) {
				break;
			}
			System.out.println("N phải là số NGUYÊN DƯƠNG vui lòng nhập lại !");
		} while (true);

		System.out.println("a: " + a + "\nb: " + b + "\nc: " + c);
		int max = Math.max(a, Math.max(b, c));
		int min = Math.min(a, Math.min(b, c));
		System.out.println("Số lớn nhất là: " + max + "\n Số nhỏ nhất là: " + min);
	}

	private static boolean nhap(int n) {
		if (n > 20) {
			return false;
		}
		return true;
	}
}
