package homeword;

import java.util.Scanner;

public class task1 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int n;
		int wrongtimes = 0;
		do {
			System.out.println("Nhập vào 1 số NGUYÊN DƯƠNG n: ");
			n = ip.nextInt();
			if (nhap(n)) {
				break;
			}
			System.out.println("N phải là số NGUYÊN DƯƠNG vui lòng nhập lại !");
			if (wrongtimes == 5) {
				System.out.println("Nhập sai 5 lần, thoát chương trình");
				ip.close();
				return;
			}
			System.out.println("Đã nhập sai lần thứ " + wrongtimes);
		} while (true);
		System.out.println("Số N là: " + n);
		boiso(n);
		ip.close();
	}

	private static void boiso(int n) {
		if (n % 2 == 0) {
			System.out.println(n + " là bội số của 2");
		} else {
			System.out.println(n + " không phải là bội số của 2");
		}
	}

	private static boolean nhap(int n) {
		if (n < 0) {
			return false;
		}
		return true;
	}

}
