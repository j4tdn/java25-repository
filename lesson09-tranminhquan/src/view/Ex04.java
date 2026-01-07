package view;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập tên tài khoản: ");
		String user = sc.nextLine();
		
		System.out.println("Nhập mật khẩu: ");
		String pass = sc.nextLine();
		
		try {
			validate(user, pass);
			System.out.println("Đăng kí thành công.");
		} catch (Exception e) {
			System.out.println("Đăng kí thất bại. " + e.getMessage());
		}
	}
	public static void validate(String user, String pass) throws Exception {
		if (pass.length() < 8) {
			System.out.println("Độ dài mật khẩu: >= 8");
			return;
		}
		
		boolean hasDigit = false;
		boolean hasUper = false;
		boolean hasSpecial = false;
		
		String special = "~!@#$%^&*";
		
		for (char c : pass.toCharArray()) {
			if (Character.isDigit(c)) {
				hasDigit = true;
			}
			if (Character.isUpperCase(c)) {
				hasUper = true;
			}
			if (special.indexOf(c) >= 0) {
				hasSpecial = true;
			}
			
			if (!hasDigit) {
				throw new Exception("Mật khẩu phải có ít nhất 1 chữ số");
			}
			if (!hasUper) {
				throw new Exception("Mật khẩu phải có ít nhất 1 kí tự in hoa");
			}
			if (!hasSpecial) {
				throw new Exception("Mật khẩu phải có ít nhất 1 kí tự đặc biệt");
			}
			int same = 0;
			for(char c1 : pass.toCharArray()) {
				if (user.indexOf(c1) >= 0) {
					same ++;
			}
		}
			if (same > 3) {
				throw new Exception("Không được trùng quá 3 ký tự với tên tài khoản");
			}
		}
	}
}
