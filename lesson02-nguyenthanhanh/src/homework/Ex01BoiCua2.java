package homework;

import java.util.Scanner;

public class Ex01BoiCua2 {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		String text;
		int max = 1;
		while(true) {
			System.out.print("Nhập n: ");
			text = ip.nextLine();
			if (isValidNumber(text)) {
				int n = Integer.parseInt(text);
				System.out.print(n + " -> " + (n%2 == 0 ? "true" : "false"));
				break;
			}
			if(max == 5) {
				System.out.println("Bạn đã nhập quá 5 lần");
				ip.close();
				return;
			}
			max++;
		}
		
		ip.close();
		
	}
	
	public static boolean isValidNumber(String text) {
		for(int i=0; i < text.length(); i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
	
}
