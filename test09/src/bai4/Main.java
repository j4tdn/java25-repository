package bai4;

import java.util.Scanner;

//Bài 4(20đ): Viết chương trình thực hiện chức năng đăng ký tài khoản
//B1. Nhập tên tài khoản ví dụ byztkhx256
//B2. Nhập mật khẩu admin123
//Yêu cầu mật khẩu như sau:
//1. Độ dài mật khẩu: >= 8
//2. Có ít nhất 1 chữ số, 1 kí tự in hoa, và một kí tự đặc biệt (~!@#$%^&*)
//3. Không được trùng quá 3 ký tự với tên tài khoản [Đăng ký khi bắt đầu chương trình]
//Sau khi đã thỏa mãn yêu cầu thông báo đăng ký tài khoản thành công
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Tên tài khoản");
		String username = sc.nextLine();
		System.out.printf("Mật khẩu");
		String password = sc.nextLine();
		if (isValidPassword(username, password)) {
			System.out.println("Đăng ký tài khoản thành công");
		} else {
			System.out.println("Đăng ký tài khoản không thành công");
		}
	}

	private static boolean isValidPassword(String username, String password) {
		if (password.length() < 8) {
			return false;
		}
		boolean hasDigit = false;
		boolean hasUper = false;
		boolean hasSpecial = false;
		String hasSpecials = "~!@#$%^&*";
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (Character.isDigit(c)) {
				hasDigit = true;
			} else if (Character.isUpperCase(c)) {
				hasUper = true;
			} else if (c == '~' || c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&'
					|| c == '*') {
				hasSpecial = true;
			}

		}
		if (hasDigit || hasUper || hasSpecial) {
			return false;
		}
		for (int i = 0; i <= password.length() - 4; i++) {
			String sub = password.substring(i, i + 4);
			if (username.contains(sub)) {
				return false;
			}
		}
		return true;
	}

}
