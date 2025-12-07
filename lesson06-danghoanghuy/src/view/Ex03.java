package view;

import java.util.Scanner;

import exception.ValidateEmail;

public class Ex03 {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("\nNhap Email: ");
				String email = ip.nextLine();
				ValidateEmail.validate(email);
				System.out.println("\nEmail hop le\n" + email);
				break;
				
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		ip.close();
	}
	
}
