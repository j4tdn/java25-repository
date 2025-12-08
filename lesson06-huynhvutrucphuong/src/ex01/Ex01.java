package ex01;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        double a = 0, b = 0;

        while (true) {
            try {
                System.out.print("Nhap a: ");
                a = Double.parseDouble(sc.nextLine());

                if (a == 0) {
                    System.out.println("Loi,Hay Nhap lai a !");
                    continue;
                }

                System.out.print("Nhap b: ");
                b = Double.parseDouble(sc.nextLine());
                break; 

            } catch (NumberFormatException e) {
                System.out.println("Sai dinh dang! Vui long nhap so.");
            }
        }

        double x = -b / a;
        System.out.println("Ket qua: x = " + x);
		
	}
}
