package assigment;

import java.util.Scanner;

public class Ex03 extends EmailUtils {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        String email;

	        while (true) {
	            System.out.print("Nhap email: ");
	            email = sc.nextLine();

	            if (isValidEmail(email)) {
	                System.out.println("Email hop le: " + email);
	                break;
	            } else {
	                System.out.println("Email khong hop le! Vui long nhap lai.\n");
	            }
	        }
	        sc.close();
	    }
}
