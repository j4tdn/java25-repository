package ex03;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        String email;
	        String regex = "^[A-Za-z0-9]+([._-][A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)+$";

	        while (true) {
	            System.out.print("Nhap email: ");
	            email = sc.nextLine();

	            if (email.matches(regex)) {
	                System.out.println("Email hop le: " + email);
	                break;
	            } else {
	                System.out.println("Email khong hop le! Vui long nhap lai.");
	            }
	        }
}
}
