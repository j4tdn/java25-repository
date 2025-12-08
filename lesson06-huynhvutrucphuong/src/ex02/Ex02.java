package ex02;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int attempts = 0;

	        while (attempts < 5) {
	            System.out.print("Nhập mật khẩu: ");
	            String pass = sc.nextLine();

	            try {
	                validate(pass);
	                System.out.println("Đăng ký thành công!");
	                return;
	            } catch (IllegalArgumentException e) {
	                System.out.println(" Lỗi: " + e.getMessage());
	                attempts++;
	                System.out.println("Nhập lại (" + (5 - attempts) + " lần còn lại)\n");
	            }
	        }

	        System.out.println("Bạn nhập sai quá 5 lần. Hủy đăng ký!");
	}
	public static void validate(String pass) {
        if (pass.length() < 8)
            throw new IllegalArgumentException("Mật khẩu phải ≥ 8 ký tự.");
        if (pass.length() > 256)
            throw new IllegalArgumentException("Mật khẩu phải ≤ 256 ký tự.");
        if (!pass.matches(".*[a-z].*"))
            throw new IllegalArgumentException("Phải có ít nhất 1 chữ thường.");
        if (!pass.matches(".*[A-Z].*"))
            throw new IllegalArgumentException("Phải có ít nhất 1 chữ hoa.");
        if (!pass.matches(".*[0-9].*"))
            throw new IllegalArgumentException("Phải có ít nhất 1 chữ số.");
        if (!pass.matches(".*[!@#$%^&*()\\-_=+\\[\\]{};:,.<>/?].*"))
            throw new IllegalArgumentException("Phải có ít nhất 1 ký tự đặc biệt.");
    }
	
}
