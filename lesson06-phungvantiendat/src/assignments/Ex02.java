package assignments;

import java.util.Scanner;

import exception.PasswordException;
import utils.PasswordUtils;


public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = 0;
		String password = "";
		do {
			try {
				++cnt;
				if(cnt > 5) {
					System.out.println("Số lần nhập đã đạt mức tối đa là 5");
					break;
				}
				System.out.println("Nhập mật khẩu: ");
				password = sc.nextLine().trim();
				if(PasswordUtils.isValidPassword(password)) {
					System.out.println("Dang ky thanh cong");
					break;
				}
			} catch (PasswordException ex) {
				if(ex.getMessages() != null) {
					System.out.println(ex.getMessages().toString());
				}else {
					System.out.println(ex.getMessage());
				}
			}
		} while (cnt <= 5);
		
	}
	
	
	
	

}
