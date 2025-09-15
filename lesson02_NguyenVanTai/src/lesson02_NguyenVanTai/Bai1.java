package lesson02_NguyenVanTai;

import java.util.Scanner;

public class Bai1 {
	public static void main(String[] args) {
		Scanner ip =new Scanner(System.in);
		int count =6;
		String text;
		do {
			System.out.printf("Hãy nhập vào một số nguyên: ");
			text=ip.nextLine();
			if(isNumber(text)) {
				int num =Integer.parseInt(text);
				if(isMutipleOf2(num)) {
					System.out.println("Đúng rồi");
					break;
				}
				--count;
				System.out.println("Bạn còn: "+count+" lần nhập");
				if(count<=0) {
					System.out.println("Thất bại!");
					ip.close();
					break;
				}
			}
			if(count<=0) {
				System.out.println("Bạn đã hết lượt nhập");
				ip.close();
				break;
			}
		}while(true);
		
	}
	private static boolean  isMutipleOf2(int num) {
		if(num<0) return false;
		if(num%2==0) return true;
		return false;
	}
	private static boolean isNumber(String text) {
		
		for(int i=0;i<text.length();i++) {
			if(!Character.isDigit(text.charAt(i))) {
				System.out.println("Ký tự bạn nhập vào không phải là số");
				return false;
			}
		}
		return true;
		}

}
