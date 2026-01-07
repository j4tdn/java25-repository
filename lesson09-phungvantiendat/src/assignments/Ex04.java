package assignments;

import java.util.Scanner;

public class Ex04 {
	private static int[] cnt = new int[255];

	public static void main(String[] args) {
		System.out.println("Nhap ten tai khoan: ");
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		
		System.out.println("Nhap mat khau: ");
		String password = sc.nextLine();
		
		if(isValidPassword(password, username)) {
			System.out.println("đăng ký tài khoản thành công");
		}else {
			System.out.println("đăng ký tài khoản that bai");
		}
		
	}
	
	public static boolean isValidPassword(String password, String account) {
		if(password.length() < 8) {
			return false;
		}
		
		if(!hasAtLeastOneNumber(password)) {
			return false;
		}
		
		if(!hasAtLeastOneSpecial(password)) {
			return false;
		}
		
		if(!hasAtLeastOneUppercaseLetter(password)) {
			return false;
		}
		
		if(!isDuplicateLessThan3Characters(password, account)) {
			return false;
		}
		
		return true;
	}
	
	private static boolean hasAtLeastOneNumber(String s) {
		int cnt = 0;
		for(int i = 0;i<s.length();++i) {
			if(Character.isDigit(s.charAt(i))) {
				++cnt;
			}
		}
		return cnt>=1;
	}
	
	
	private static boolean hasAtLeastOneUppercaseLetter(String s) {
		int cnt = 0;
		for(int i = 0;i<s.length();++i) {
			if(Character.isUpperCase(s.charAt(i))) {
				++cnt;
			}
		}
		return cnt>=1;
	}
	

	private static boolean hasAtLeastOneSpecial(String s) {
		for(int i = 0;i<s.length();++i) {
			if(s.charAt(i) == '~'||s.charAt(i) == '@'||s.charAt(i) == '!'||s.charAt(i) == '#'||s.charAt(i) == '%'||s.charAt(i) == '^'||s.charAt(i) == '&'||s.charAt(i) == '*') {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isDuplicateLessThan3Characters(String password, String account) {
		for(int i = 0;i<account.length();++i) {
			cnt[account.charAt(i)]++;
		}
		
		int ans = 0;
		
		for(int i = 0;i<password.length();++i) {
			cnt[password.charAt(i)]++;
			if(cnt[password.charAt(i)] > 1) {
				++ans;
			}
		}
		
//		
//		for(int i = 0;i<255;++i) {
//			if(cnt[i] > 1) {
//				++ans;
//			}
//		}
		return ans < 3;
		
	}
}
