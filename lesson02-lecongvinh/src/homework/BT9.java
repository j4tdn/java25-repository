package homework;

import java.util.Scanner;

public class BT9 {

	/*
	 * 9: Viết chương trình tìm số nguyên tố thứ 200 trong hệ thống số tự nhiên.
	
	 */
	public static void main(String[] args) {
		
	
		 
		int count =0;
		int k= 200;
		int num=1;
		while(count<=k) {
			num++;
			if(SNT(num)) {
				count++;
			}
		}
		System.out.println("Số nguyên tố thứ 200 là: " + num);
		
	}
	
	private static boolean SNT(int n) {
		
		if(n<2) {
			return false;
		}
		for(int i =2; i<=Math.sqrt(n);i++) {
			if(n%i==0 ) {
				return false;
				}
		
		}
				return true;
			
		}
}
