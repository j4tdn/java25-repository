package homework;

import java.util.Scanner;

public class Ex08SoNguyenTo {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		String text;
		int max = 1;
		while(true) {
			System.out.print("Nhập n: ");
			text = ip.nextLine();
			if (Ex01BoiCua2.isValidNumber(text)) {
				int n = Integer.parseInt(text);
				System.out.print(n + " -> " + (isPrime(n) ? "true" : "false"));
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
	
	public static boolean isPrime(int number) {
		if(number < 2) {
			return false;
		}
		
		if(number == 3) {
			return true;
		}
		
		for(int i = 2; i <= number/2; i++) {
			if(number%i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
