package ex02;

import java.util.Scanner;

public class PasswordRegister {

	private static final int MAX_ATTEMPTS = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int attempts = 0;

		while (attempts < MAX_ATTEMPTS) {
			System.out.print("Nhập mật khẩu đăng ký: ");
			String password = sc.nextLine();

			try {
				validatePassword(password);

				System.out.println("Đăng ký tài khoản thành công!");
				break;

			} catch (InvalidPasswordException e) {
				attempts++;
				System.out.println("Lỗi:\n" + e.getMessage());
				System.out.println("Số lần thử còn lại: " + (MAX_ATTEMPTS - attempts));

				if (attempts == MAX_ATTEMPTS) {
					System.out.println("Bạn đã nhập sai quá " + MAX_ATTEMPTS + " lần. Đăng ký thất bại.");
				}
			}
		}

		sc.close();
	}

	private static void validatePassword(String password) throws InvalidPasswordException {
		StringBuilder error = new StringBuilder();

		// 1. Độ dài
		if (password.length() < 8) {
			error.append("- Mật khẩu phải có ít nhất 8 ký tự.\n");
		}
		if (password.length() > 256) {
			error.append("- Mật khẩu không được vượt quá 256 ký tự.\n");
		}

		// 2. Có chữ thường
		if (!password.matches(".*[a-z].*")) {
			error.append("- Mật khẩu phải chứa ít nhất 1 chữ thường (a-z).\n");
		}

		// 3. Có chữ hoa
		if (!password.matches(".*[A-Z].*")) {
			error.append("- Mật khẩu phải chứa ít nhất 1 chữ hoa (A-Z).\n");
		}

		// 4. Có chữ số
		if (!password.matches(".*\\d.*")) {
			error.append("- Mật khẩu phải chứa ít nhất 1 chữ số (0-9).\n");
		}

		// 5. Có ký tự đặc biệt
		if (!password.matches(".*[!@#$%^&*()_+\\-=`~\\[\\]{};':\"\\\\|,.<>/?].*")) {
			error.append("- Mật khẩu phải chứa ít nhất 1 ký tự đặc biệt.\n");
		}

		if (error.length() > 0) {
			throw new InvalidPasswordException(error.toString());
		}
	}

	private static class InvalidPasswordException extends Exception {
		public InvalidPasswordException(String message) {
			super(message);
		}
	}
}
