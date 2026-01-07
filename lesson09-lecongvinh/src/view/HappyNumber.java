package view;

import java.util.Scanner;

public class HappyNumber {
	public static void main(String[] args) {
	

	Scanner sc = new Scanner(System.in);
	System.out.println("Nhập số: ");
	int num =sc.nextInt();
	int a= num;
	StringBuffer buf = new StringBuffer();
	while(true) {
		buf.append(num);
		num =sum(num);
		if(num==1) {
			System.out.println(a +" là số Hạnh Phúc");
			break;
		}
		
		if(String.valueOf(buf).contains(String.valueOf(num))) {
		System.out.println(a+ " không phải là số Hạnh Phúc");
		break;
			}
		}
	}
	
private static int sum(int num) {
	int n =0;
	while(num>0) {
		int a =num%10;
		num = num/10;
		n+=a*a;
	}
	return n;
}
}
