package bai2;

import java.util.Scanner;

public class main {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while(n<5) {
			try {
				System.out.println("Password: ");
				String pass = sc.nextLine();
				
				if(isValidPassword(pass)) {
					System.out.println("Sign up successfully");
					return;
				}
			}catch (Exception e) {
				n++;
				System.out.println("Error: " + e.getMessage());
				System.out.println("\n " + (5-n) +" try again.");
			}
		}
		
		System.out.println("5 times wrongtimes, unscribe");
		sc.close();
	}
	
	public static boolean isValidPassword(String pass) throws Exception {
		if(pass.length() < 8) {
			throw new  Exception("Require: At least 8 characters");
		}
		if(pass.length() > 256) {
			throw new Exception("Require: At most 256 characters");
		}
		if(!pass.matches(".*[a-z].*")) {
			throw new Exception("Require: At least 1 lowercase alphabetic character");
		}
		if(!pass.matches(".*[A-Z].*")) {
			throw new Exception("Require: At least 1 uppercase alphabetic character");
		}
		if(!pass.matches(".*[0-9].*")) {
			throw new Exception("Require:At least 1 number(1,2,3...)");
		}
		if(!pass.matches(".*.*[!@#$%^&*()\\\\-_=+{}\\\\[\\\\]:;\\\"'<>,.?/].*")) {
			throw new Exception("Require: At least 1 special character");
		}
		return true;
	}
	
}
