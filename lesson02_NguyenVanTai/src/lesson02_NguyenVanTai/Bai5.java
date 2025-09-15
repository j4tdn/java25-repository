package lesson02_NguyenVanTai;

import java.util.Scanner;

public class Bai5 {
public static void main(String[] args) {
	int count=5;
	String text;
	Scanner ip =new Scanner(System.in);
	System.out.println("Chương trình nhập số đối xứng");
	
	while(count>0) {
		
		System.out.printf("Nhập số: ");
		text=ip.nextLine();
		if(isNumber(text)) {
			int number=Integer.parseInt(text);
			if(number>9) {
				if(reverseNumber(number)) {
					System.out.println("Số "+ number+ " là số đối xứng");
					count=0;
				}
				
				ip.close();
				
			}else {
				System.out.println("Đây không phải là số đối xứng");
				--count;
				System.out.println("Số lần nhập còn: "+count);
			}
			
			
		}else {
			System.out.println("Nhập sai rồi vui lòng nhập lại");
			--count;
			System.out.println("Số lần nhập còn: "+count);
		}
		
		
	}
	
}
private static boolean reverseNumber(int ip) {
	int n=ip;
	int m=0;
	while(n>0) {
		int temp=n%10;
		 n =n/10;
		m=m*10+temp;
	}
	if(m==ip) {
		return true;
	}
	return false;
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

