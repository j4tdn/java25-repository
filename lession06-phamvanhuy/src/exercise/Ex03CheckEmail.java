package exercise;

import java.util.Scanner;

public class Ex03CheckEmail {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String email = "";
		
		while(true) {
			try {
				System.out.println("Nhập email: ");
				email = sc.nextLine();
				
				if(!isValidEmail(email)) {
					throw new Exception("email không hợp lệ");
				}
				
				System.out.println("email hợp lệ: " + email);
				break;
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static boolean isValidEmail(String email) {
	        return email.matches("^[a-zA-Z0-9]+([._-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+$");
	    }
}
