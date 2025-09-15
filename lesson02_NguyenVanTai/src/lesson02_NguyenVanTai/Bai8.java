package lesson02_NguyenVanTai;

import java.util.Scanner;

public class Bai8 {
	public static void main(String[] args) {
		Scanner ip =new Scanner(System.in);
		String text;
		int count =6;
		while(count>0) {
			System.out.println("Chương trình kiểm tra số nguyên tố");
			System.out.printf("Nhập: \n");
			text=ip.nextLine();
			if(isNumber(text)) {
				int i =Integer.parseInt(text);
				if(isPrime(i)) {
					System.out.printf("%d là số nguyên tố",i);
					ip.close();
					break;
				}else {
					--count;
					System.out.printf("%d không phải là số nguyên tố\n",i);
					System.out.printf("Bạn còn %d lượt nhập",count);
				}
				
			}else {
				--count;
				System.out.printf("Bạn còn %d lượt nhập",count);
				
			}
		}
		
		
	}
	private static boolean isPrime(int n) {
		if(n<2) return false;
		for(int i=2;i<Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		
		}
		return true;
		
	}
	private static boolean isNumber(String text) {
		for(int i=0;i<text.length();i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
