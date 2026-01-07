package assignments;

import java.util.Scanner;

public class Ex04 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Nhập tên tài khoản: ");
	String username = sc.nextLine();
	
	System.out.println("Nhập mật khẩu: ");
	String password = sc.nextLine();
	if(utils.RegisterAccount.isValidPassword(username,password)) {
		System.out.println("Đăng ký tài khoản thành công!");
		
	} else {
		System.out.println("Mật khẩu không hợp lệ!");
	}
	sc.close();
}
}
