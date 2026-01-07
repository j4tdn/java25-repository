package view;

import java.util.Scanner;

/*
 
Bài 4(20đ): Viết chương trình thực hiện chức năng đăng ký tài khoản
B1. Nhập tên tài khoản ví dụ byztkhx256
B2. Nhập mật khẩu admin123
Yêu cầu mật khẩu như sau:
1. Độ dài mật khẩu: >= 8
2. Có ít nhất 1 chữ số, 1 kí tự in hoa, và một kí tự đặc biệt (~!@#$%^&*)
3. Không được trùng quá 3 ký tự với tên tài khoản [Đăng ký khi bắt đầu chương trình]
Sau khi đã thỏa mãn yêu cầu thông báo đăng ký tài khoản thành công
 */

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("Nhap tai khoan: ");
			String username = sc.nextLine();
			
			System.out.println("Nhap mat khau: ");
			String password = sc.nextLine();
			
			if(isValid(username, password)) {
				System.out.println("đăng ký tài khoản thành công");
				break;
			}
			else System.out.println("that bai");
		}
		
		sc.close();
		
	}
	
	private static boolean isValid(String username, String password) {
		
		if(password.length() < 8) return false;
		
		if (!password.matches(".*[0-9].*")) return false;
		
		if (!password.matches(".*[A-Z].*")) return false;
		
		if (!password.matches(".*[~!@#$%^&*].*")) return false;
		
		//  Không được trùng quá 3 ký tự với tên tài khoản
		for(int i = 0; i <= password.length() - 3; i++) {
			
			String str = password.substring(i, i + 3);
			if(username.contains(str)) {
				 return false;
			}
			
		}
		
		return true;
	}
	
}
