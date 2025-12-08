package exercises;

import java.util.Scanner;

public class Ex03 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String email = inputValidEmail();
		System.out.println("Email hợp lệ: " + email);
	}

	public static String inputValidEmail() {
		String email;

		while (true) {
			System.out.printf("Nhập email: ");
			email = sc.nextLine();

			if (isValidEmail(email)) {
				return email;
			} else {
				System.out.println("Email kh hợp lệ, nhập lại!!");
			}
		}
	}

	public static boolean isValidEmail(String email) {

		String regex = "^[A-Za-z0-9]+([._-][A-Za-z0-9]+)*@[A-Za-z0-9-]+\\.[A-Za-z]{2,}$";
//bắt đầu chuỗi với từ A-Z hoặc từ a-z và có thể là từ 0-9 sau đó bắt buộc có các kí tự kia và sau đó là số hoặc chữ(1 hoặc nhiều(+)) dấu nhân là lặp lại nhiều lần
		// sau đó @ và tiếp tục số hoặc chữ số và dấu . cuối cùng là tên miền, có tối
		// thiểu 2 ký tự và dấu $ kết thúc chuỗi
		return email.matches(regex);
	}
}
