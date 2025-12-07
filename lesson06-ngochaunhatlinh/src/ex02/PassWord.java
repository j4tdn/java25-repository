package ex02;

import java.util.Scanner;

public class PassWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pass = "";

		int temp = 0;
		int dem = 5;

		while (temp < dem) {
			System.out.println("Nhập mật khẩu mới: ");
			pass = sc.nextLine();

			try {
				if (isPassWord(pass)) {
					System.out.println("Đăng ký thành công! Mật khẩu hợp lệ");
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
				temp++;

				if (temp < dem) {
					System.out.println("Còn (" + (dem - temp) + " lần thử!!).\n");
				} else {
					System.out.println(" Quá nhiều lần thử không thành công. Đã hủy đăng ký.");
				}
			}

		}
		sc.close();

	}

	public static boolean isPassWord(String pass) throws Exception {
		if (pass.length() < 8) {
			throw new Exception("Mật khẩu phải chứa ít nhất 8 ký tự.");
		}
		if (pass.length() > 256) {
			throw new Exception("Mật khẩu không được vượt quá 256 ký tự.");
		}
		if (!pass.matches(".*[0-9].*")) {
            throw new Exception("Mật khẩu phải chứa ít nhất 1 số.");
        }

        if (!pass.matches(".*[!@#$%^&*()\\-_=+{}\\[\\]:;\"'<>,.?/].*")) {
            throw new Exception("Mật khẩu phải chứa ít nhất 1 ký tự đặc biệt.");
        }

		return true;
	}

}
