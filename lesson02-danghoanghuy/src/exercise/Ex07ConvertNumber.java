package exercise;

import java.util.Scanner;

public class Ex07ConvertNumber {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhap so");
		int number = ip.nextInt();
		
		convertNumber(number);
		
		ip.close();
	}
	
	private static void convertNumber(int number) {
		 if (number == 0) {
		        System.out.println("0");
		        return;
		    }
		    String binaryResult = ""; 
		    while (number > 0) {
		        int remainder = number % 2;
		        binaryResult = remainder + binaryResult;
		        number = number / 2; 
		    }
		    System.out.println(binaryResult);
		}			   
}
