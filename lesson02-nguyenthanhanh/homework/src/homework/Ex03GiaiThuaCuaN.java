package homework;

import java.util.Scanner;

public class Ex03GiaiThuaCuaN {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		String text;
		int max = 1;
		while(true) {
			System.out.print("Nhập n: ");
			text = ip.nextLine();
			if (Ex01BoiCua2.isValidNumber(text) && Integer.parseInt(text) >= 0) {
				int n = Integer.parseInt(text);
				System.out.print(n + "! -> " + calcFactorial(n));
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
	
	public static int calcFactorial(int n) {
		if(n <= 0) {
			return -1;
		}
		
		int factorial = 1;
		for (int i = 2; i <= n; i++) {
	        factorial *= i;
	    }
	    return factorial;
	}
	
}
