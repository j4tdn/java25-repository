package homeword;

import java.util.Scanner;

/**
 * Bài 8: Viết chương trình(hàm) kiểm tra số nguyên N có phải là số nguyên tố
 * hay không Biết rằng N là số nguyên dương được nhập từ bàn phím, bắt buộc nhập
 * lại nếu N không hợp lệ (tối đa 5 lần) hoặc khai báo biến có sẵn giá trị hợp
 * lệ VD: Nhập N = abc → báo lỗi, yêu cầu nhập lại
 * 
 * = 4 → false
 * 
 * = 7 → true
 */
public class task8 {

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
		
		
		if (snt(n)) {
			System.out.println(n + " Là số nguyên tố");
		} else {
			System.out.println(n + " không Là số nguyên tố");
		}

	}

	private static boolean nhap(int n) {
		if (n < 0) {
			return false;
		}
		return true;
	}

	private static boolean snt(int n) {
		if (n <= 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		return true;
	}
}
