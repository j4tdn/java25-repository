package view;

import java.util.Scanner;

public class Ex04 {
	
	static boolean valid(String u, String p) {
		if(p.length() < 8) return false;
		
		boolean d = false, up = false, sp = false;
		String s = "~!@#$%^&*";
		
		for(int i = 0; i< p.length(); i++) {
			char c = p.charAt(i);
			if(c >= '0' && c <= '9') d = true;
			if(c >= 'A' && c <= 'Z') up = true;
			for(int j = 0; j < s.length(); j++)
				if(c == s.charAt(j)) sp = true;
		}
		if(!(d && up && sp)) return false;
		for(int i = 0; i <= u.length() - 4; i++)
			for(int k = 0; k <= p.length() - 4; k++) {
				boolean same = true;
				for(int j = 0; j < 4; j++) {
					if (u.charAt(i + j) != p.charAt(k + j)) {
						same = false;
						break;
					}
				}
				if(same) return false;
			}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Username: ");
		String u = sc.nextLine();
		System.out.println("Password: ");
		String p = sc.nextLine();
		
		if(valid(u, p))
			System.out.println("Đăng kí tài khoản thành công");
		else
			System.out.println("Mật khẩu không hợp lệ");
	}
}
