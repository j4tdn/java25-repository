package bai1;


import java.util.Scanner;

/*
 * Bài 1: Giải phương trình bậc nhất ax + b = 0 . Các hệ số a,b nhập vào từ bàn phím.
Sử dụng try - catch để bẫy lỗi khi nhập sai dữ liệu, ví dụ nhập số nhưng nhập chữ.
Bẫy lỗi chia 0, trường hợp xảy ra lỗi phải thông báo cho người dùng biết và nhập lại đến khi a b
hợp lệ thì in ra kết qua x = -b/a
 */
public class main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		
		while (true) {
		try {
			System.out.println("Nhập a");
			int a = Integer.parseInt(sc.nextLine());

			System.out.println("Nhập b");
			int b = Integer.parseInt(sc.nextLine());
			System.out.println("Kết quả: " + Equation(a, b));
			break;
		}catch (NumberFormatException e) {
			System.out.println("Vui lòng nhập số\n"); 
		}
			catch (ArithmeticException e) {
			System.out.println("Lỗi :"+e.getMessage());
			}
		}
		
		sc.close();
	}

	private static int Equation(int a, int b) {
		if (a == 0) {
			throw new ArithmeticException("Vui lòng nhập lại");
		}
		return -b / a;

	}
	}

