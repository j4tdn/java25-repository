package view;

import java.time.Year;
import java.util.Scanner;

public class Ex01AgeYearProblem {
	
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhặp năm sinh: ");
		
		int yob = Integer.parseInt(ip.nextLine());
		
		int age = Year.now().getValue() - yob + 1;
		System.out.println(age);
		ip.close();
		
	}

}
