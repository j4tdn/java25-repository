package view;

import java.time.Year;
import java.util.Scanner;

public class Ex01AgeYearValidation {
	
	// Dat van de
	// Bai toan: Nhap vao nam sinh cua nguoi dung, in ra so tuoi cua nguoi do
	//         : Tuoi = Nam hien tai + Nam sinh + 1
	
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhap nam sinh:");
		
		String text = "";
		do {
			text = ip.nextLine();
			if(text.matches("\\d+")) {
				break;
			}
			System.out.println("Nam sinh k hop le");
		} while(true);
		
		// Dong duoi: Co kha nang xay ra ngoai le
		// Cach 1: Su dung Validatiion, dam bao coe duoi k xay ra ngoai le
		// Hieu logic va cach xu ly de thuc hien validate
		int yob = Integer.parseInt(ip.nextLine());
		
		int age = Year.now().getValue() - yob + 1;
		
		System.out.println("\n==> So tuoi = " + age);
		
		ip.close();
	}
	
}

