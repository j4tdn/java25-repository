package lesson02_NguyenVanTai;

import java.util.Scanner;

public class Bai2 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
	
		int count =5;
		String text;
		while(count>0) {
			System.out.printf("Nhập vào số nguyên: ");
			text=ip.nextLine();
			if(checkIsNumber(text)) {
				int num=Integer.parseInt(text);
				if(checkPowerOfTwo(num)) {
					System.out.println("Đúng rồi");
					ip.close();
					return ;
				}
				count--;
				System.out.println("Bạn còn " +count+" lần nhập!");
			}
			
		}
		System.out.println("Bạn đã hết lượt nhập!!");
		ip.close();
	}
	
	private static boolean checkPowerOfTwo(int num) {
		if(num==1) {
			return true;
		}
		while(num%2==0 && num>0) {
			num/=2;
			if(num ==1) {
			return true;	
			}
		}
		return false;
	}
	private static boolean checkIsNumber(String text) {
		for(int i=0;i<text.length();i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	

}
