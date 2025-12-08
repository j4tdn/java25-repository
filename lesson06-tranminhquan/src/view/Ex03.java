package view;

import java.util.Scanner;

public class Ex03 {

	public static void checkEmail(String email) throws Exception {
		if(email.contains(" ")) {
			throw new Exception("Email k đc chứa khoảng trắng");
		}
		int ido = email.indexOf("@");
		int lido = email.lastIndexOf("@");
		if(ido == -1 || ido != lido) {
			throw new Exception("Email chỉ bắt buộc phải có 1 @");
		}
		String before = email.substring(0, ido);
		String after = email.substring(ido + 1);
		if(before.length() <= 0) {
			throw new Exception("Phần trước @ k được để trống");
		}
		if(after.length() <= 0) {
			throw new Exception("Phần sau @ k được để trống");
		}
		if(!after.contains(".")) {
			throw new Exception("Phần sau phải chứa dấm chấm(.)");
		}
		if(after.startsWith(".") || after.endsWith(".")) {
			throw new Exception("Phần sau @ k đc bắt đầu và kết thúc bằng dấu chấm(.)");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String email;
		
		while (true) {
			System.out.println("Nhập email: ");
			email = sc.nextLine();
			
			try {
				checkEmail(email);
				System.out.println("Hợp lệ!");
				break;
			} catch (Exception e) {
				System.out.println("Lỗi: " + e.getMessage());
			}
		}
	}
}
