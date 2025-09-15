package homeword;

import java.util.Scanner;

/**
 * Bài 2: Viết chương trình(hàm) kiểm tra số nguyên N có phải là lũy thừa của 2
 * hay không Biết rằng N là số nguyên dương được nhập từ bàn phím, bắt buộc nhập
 * lại nếu N không hợp lệ (tối đa 5 lần) hoặc khai báo biến có sẵn giá trị hợp
 * lệ VD: Nhập N = abc → báo lỗi, yêu cầu nhập lại
 * 
 * = 4 → true = 6 → false = 8 → true = 9 → false
 */
public class task2 {
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
		luythua(n);
		ip.close();
		return;
	}

	private static void luythua(int n) {
		if (n > 0 && (n & (n - 1)) == 0) {
			System.out.println(n + " Là lũy thừa của 2");
		} else {
			System.out.println(n + " Không phải là lũy thừa của 2");
		}
	}

	private static boolean nhap(int n) {
		if (n < 0) {
			return false;
		}
		return true;
	}
}
