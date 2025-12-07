package view;

import java.util.Scanner;

import exception.ValidatePassword;

public class Ex02 {
	
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		int wrongTimes = 0;
		
		do {
			try {
				System.out.println("\nNhap Password: ");
				String pw = ip.nextLine();
				ValidatePassword.validate(pw);
				
				System.out.println("Dang ki thanh cong");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				wrongTimes++;
			}
		} while (wrongTimes <= 5);
		
		System.out.println("\nNhap qua 5 lan nhotttttttt");
		ip.close();
	}
	
}
