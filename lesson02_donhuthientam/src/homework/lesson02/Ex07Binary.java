package homework.lesson02;

import java.util.Scanner;

public class Ex07Binary {
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhập N");
		int number = ip.nextInt();
		
		ip.close();
		
		System.out.println(isvalid(number));
		
	}
	
	private static int isvalid(int val) {
		int num = 0;
		while(val > 0) {
			num = num * 10 + val % 2;
			val = val / 2;
		}
		return num;
	}

}
