package ex04;

import java.util.Scanner;


public class Ex04 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Nhập tên tài khoản: ");
		String username = sc.nextLine();
		
		System.out.println("Nhập mật khẩu: ");
		String password = sc.nextLine();
		
		if(isValid(username,password)) {
			System.out.println("Đăng kí tài khoản thành công");
		}else {
			System.out.println("Mật khẩu không hợp lệ ");
		}
	}

	private static boolean isValid(String username, String password) {
		//1.Đọ dài
		if(password.length() < 8 ) return false;
		
		boolean hasDigit = false;
		boolean hasUpper = false;
		boolean hasSpecial = false;
		String special ="~!@#$%^&*";
		
		//2.Kiểm tra kí tự 
		for (int i = 0; i< password.length();i++) {
			char c = password.charAt(i);
			
			if(c >= '0' && c<= '9') hasDigit =true;
			else if(c >= 'A' && c<='Z') hasUpper = true;
			else if( special.indexOf(c)!= -1) hasSpecial = true;
		}
		
		//3.Không được trùng quá 3 ký tự với tên tài khoản [Đăng ký khi bắt đầu chương trình]
		int count = 0;
		for(int i = 0; i< Math.min(username.length(),password.length());i++) {
			if( username.charAt(i) == password.charAt(i) ) {
				count++;
				if(count > 3) return false;
			}
			else {
				count = 0 ;
			}
		}
		return true;
	}
}
