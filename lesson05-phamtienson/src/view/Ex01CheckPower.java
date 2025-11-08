package view;

import java.util.Scanner;

public class Ex01CheckPower {
	public static void main(String[] args) {
	Scanner ip = new Scanner(System.in);
	System.out.println("Nhập 2 số nguyên:  ");
	int a = ip.nextInt();
	int b = ip.nextInt();
	
	if (b > a ) {
		int c = a;
		a = b;
		b = c;
	}
	if (b <= 0) {
		System.out.println("false");
	}
	else if (b == 1) {
		if (a == 1) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
	else {
		while (a % b ==0) {
			a = a / b;
		}
		if (a == 1) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
	ip.close();
	}

}
