package exercise;

import java.util.Scanner;

public class Ex01MultipleOf2 {
	public static void main(String[] args) {
		String Text;
		Scanner ip = new Scanner(System.in);
		int wrongTimes = 0;
		
		do {
			System.out.println("Nhap vao 1 so nguyen");
			Text = ip.nextLine();
			if(isValid(Text)) {
				break;
			}
			if(++wrongTimes == 6) {
				System.out.println("Nhap sai qua 5 lan, nhotttt");
				ip.close();
				return;
			}
			System.out.println("Chua phai so hop le");
		}
		while(true);
		int number = Integer.parseInt(Text);
		isMulOf2(number);
		ip.close();
	}
	
	public static boolean isValid(String Text) {
		for(int i = 0; i < Text.length(); i++) {
			if(!Character.isDigit(Text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static int isMulOf2(int number) {
		if(number % 2 == 0) {
			System.out.println(number + " la boi cua 2");
			return number;
		}
		System.out.println(number + " khong phai la boi cua 2");
		return number;
	}
}
