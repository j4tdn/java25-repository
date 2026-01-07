package Ex04;

import java.util.Scanner;

public class Account {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap ten tk: ");
		String username = sc.nextLine();
		System.out.println("Nhap matkhau: "); 
		String password = sc.nextLine();
		
		if(isPassword(password)) {
			System.out.println("Dang ki thanh cong");
		}else {
			System.out.println("Dang ki khong thanh coong ");
		}
		
	}
	
	public static boolean isPassword(String password) {
		if(password.length() < 8) return false;
		
		boolean upper = password.matches(".*[A-Z].*");
		boolean special = password.matches(".*[~!@#$%^&*].*");
		boolean number = password.matches(".*[0-9].*");
		
		if(!(upper && special && number)) return false;
		
		return true;
	}
}
