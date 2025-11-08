package ex03;

import java.util.Scanner;

public class MaxValidNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập chuỗi: ");
		String s = sc.nextLine();
		
		int max = getMaxvalidNumber(s);
		System.out.println("Số lớn nhất trong chuỗi là: " + max);
	}
	static int getMaxvalidNumber(String s) {
		int so = 0;
		int max = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c >= '0' && c <= '9') {
				so = so * 10 + (c - '0');
			}else {
				if(so > max)
					max = so;
				so = 0;
			}
		}
		if(so > max)
			max = so;
		
		return max;
	}
}
