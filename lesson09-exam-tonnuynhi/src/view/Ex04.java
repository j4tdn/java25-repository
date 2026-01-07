/*
 * Bài 4(20đ): Viết chương trình thực hiện chức năng đăng ký tài khoản
B1. Nhập tên tài khoản ví dụ byztkhx256
B2. Nhập mật khẩu admin123
Yêu cầu mật khẩu như sau:
1. Độ dài mật khẩu: >= 8
2. Có ít nhất 1 chữ số, 1 kí tự in hoa, và một kí tự đặc biệt (~!@#$%^&*)
3. Không được trùng quá 3 ký tự với tên tài khoản [Đăng ký khi bắt đầu chương trình]
Sau khi đã thỏa mãn yêu cầu thông báo đăng ký tài khoản thành công
 */

package view;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input account: ");
		String username = scanner.nextLine();
		System.out.println("Input password: ");
		String password = scanner.nextLine();
		
		if (isValidPassword(password, username)) {
			System.out.println("Signup Successful");
		}else {
			System.out.println("The password is invalid ");
		}
		
	}
	
	static boolean isValidPassword(String password, String username) {
		if(password.length()< )
	}

}
