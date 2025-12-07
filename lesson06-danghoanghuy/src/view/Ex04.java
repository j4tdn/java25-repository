package view;

import java.util.Scanner;

import exception.ValidateNumber;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("Nhap so: ");
				int num = Integer.parseInt(ip.nextLine());
				
				String result = ValidateNumber.readNumber(num);
				System.out.println("n = " + num + " => " + result + "\n");
				
			} catch (NumberFormatException e) {
				System.out.println("Nhap lai so, k phai chu");
			}
		}

	}
	
}
