package view;

import java.time.Year;
import java.util.Scanner;

public class Ex03AgeYearTryCatch {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhập năm sinh: ");
		int yob = 0;
		try {
		     yob = Integer.parseInt(ip.nextLine());
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		int age = Year.now().getValue() - yob+1;
		System.out.println("\n ==> số tuổi = "+age);
		ip.close();
		}
}
