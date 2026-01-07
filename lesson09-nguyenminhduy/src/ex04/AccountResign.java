package ex04;

import java.util.Scanner;

public class AccountResign {
	
	public static boolean validPass(String username, String pass) {
		if(pass.length() < 8) return false;
		if(!pass.matches(".*[0-9].*")) return false;
		if(!pass.matches(".*[A-Z].*")) return false;
		if(!pass.matches(".*[~!@#$%^&*].*")) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập tên tài khoản: ");
		String username = sc.nextLine();
		
		System.out.println("Nhập mật khẩu: ");
		String pass = sc.nextLine();
		
		if(validPass(username, pass)) {
			System.out.println("Đăng ký thành công");
		}else {
			System.out.println("Mật khẩu không hợp lệ");
		}
	}

}
