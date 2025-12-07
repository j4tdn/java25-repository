package view;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("Nhap a: ");
				double a = Double.parseDouble(ip.nextLine());
				
				if(a == 0) {
					throw new ArithmeticException("Can nhap a != 0, NHAP LAI!!!!!!!");
				}
				
				System.out.println("Nhap b: ");
				double b = Double.parseDouble(ip.nextLine());
				
				double res = -b / a;
				System.out.println("====== Ket qua ======");
				System.out.println("-" + b + " / " + a + " = " + res);
				break;
			
			} catch (NumberFormatException ne) {
				System.out.println("Nhap so k phai nhap chu, NHAP LAI!!!!!!!");
				
			} catch (ArithmeticException ae) {
				System.out.println("Can nhap a != 0, NHAP LAI!!!!!!!");
					
			}
		}
		ip.close();
	}
	
}
