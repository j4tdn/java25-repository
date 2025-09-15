package homework;

import java.util.Scanner;

public class Ex02LuyThuaCua2 {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		String text;
		int max = 1;
		while(true) {
			System.out.print("Nhập n: ");
			text = ip.nextLine();
			if (Ex01BoiCua2.isValidNumber(text)) {
				int n = Integer.parseInt(text);
				System.out.printf(n + " -> " + (isPowerOfTwo(n) ? "true" : "false"));
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
	
	private static boolean isPowerOfTwo(int n) {
		if (n <= 0) {
	        return false;
	    }
		
	    while(n%2 == 0) {
	        n = n / 2;
	    }
	    
	    return n == 1;
	}
	
}
