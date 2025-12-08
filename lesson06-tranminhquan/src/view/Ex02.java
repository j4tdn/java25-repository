package view;

import java.util.Scanner;

public class Ex02 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String password;
		
		while (count <= 5) {
			System.out.println("Nhập password: ");
			password = sc.nextLine();			
		
		try {
			checkPassword(password);
			System.out.println("Thành công!");
			return;
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			count++;
			System.out.println("Còn " + (5 - count) + " lần nhập");
		}
	 
		System.out.println("Nhập hết 5 lần. Hủy");
        }
	}
		public static void checkPassword(String pass) throws Exception {
		
		if (pass.length() < 8) {
			throw new Exception("Mật khẩu phải có ít nhất 8 kí tự");
		}
		if (!pass.matches(".*[a-z].*")) {
			throw new Exception("Mật khẩu phải có ít nhất 1 kí tự thường");
		}
		if (!pass.matches(".*[A-Z].*")) {
			throw new Exception("Mật khẩu phải có ít nhất 1 kí tự hoa");
		}
		if (!pass.matches(".*[0-9].*")) {
			throw new Exception("Mật khẩu phải có ít nhất 1 kí tự số");
		}
		if (!pass.matches(".*[^a-zA-Z0-9].*")) {
			throw new Exception("Mật khẩu phải có ít nhất 1 kí tự đặc biệt");
		}
	}
}
