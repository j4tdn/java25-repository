package lesson02_NguyenVanTai;

import java.util.Scanner;

public class Bai3 {
	public static void main(String[] args) {
		int count =5;
		Scanner ip= new Scanner(System.in);
		String text;
		while(count>0) {
			System.out.printf("Nhập vào số nguyên: ");
			text=ip.nextLine();
			if(isNumber(text)) {
				long num =Long.parseLong(text);
				System.out.println("giai thừa:"+factorial(num));
				ip.close();
				break;
			}
		}
	}
	private static boolean isNumber(String text) {
		for(int i=0;i<text.length();i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	private static long factorial(long num) {
		if(num==1 || num==0) {
			return 1;
		}
		long result=1;
		for(int i=2;i<=num;i++) {
				 result *=i;
		}
		return result;
		
	}
	

}
