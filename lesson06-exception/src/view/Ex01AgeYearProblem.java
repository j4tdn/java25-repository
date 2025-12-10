package view;

import java.time.Year;
import java.util.Scanner;

public class Ex01AgeYearProblem {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhap nam sinh: ");
		
		String text = "";
		
		do {
			text = ip.nextLine();
			if ( text.matches("\\d+")) {
				break;
			}
			System.out.print("nam sinh khong hop le, vui long nhap lai");
		} while (true);
		
		
		int yob = Integer.parseInt(text);
		
		int age = Year.now().getValue() - yob + 1;
		
		System.out.println("\n==> so toi = " + age);
		
		ip.close();
	}

}
