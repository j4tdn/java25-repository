package homework;

import java.util.Scanner;

public class BT6 {
/*
 * 6: Viết chương trình tìm số nguyên lớn, nhỏ nhất trong 3 chữ số a,b,c
	Biết rằng a,b,c là số nguyên được nhập từ bàn phím và nhỏ hơn 20 [0, 20)
	VD: Nhập a = 6
	Nhập b = “xyz” → báo lỗi, yêu cầu nhập lại
	Nhập b = 12
	Nhập c = 8
	Số lớn nhất là 12
	Số nhỏ nhất là 6
 */
public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		String text;
		int count =0;
		int number=-1;
		int a =0;
		int b= 0;
		int c =0;
		do {
			System.out.print("Nhập số nguyên: ");
			text = ip.nextLine();
			
			if (isValidText(text)) {
				 number = Integer.parseInt(text);
				if(number>=0 && number<20 ) {
					count++;
					if(count ==1) {
						a =number; 
					}else if(count ==2) {
						 b =number;
					}else if (count ==3) {
						 c= number;
						 break;
					}
					
				}
				else {
					System.out.println("Ko phải số hợp lệ \n");
				}
			}
			
			else {
				System.out.println("Chưa phải là chữ số hợp lệ \n");
			}
			
			
		} while (true);
		
		int max = Math.max(a, Math.max(b, c));
		int min = Math.min(a, Math.min(b, c));
		
		
		System.out.println("Số lớn nhất: " +max);
		System.out.println("Số bé nhất: " +min);
		
		
		ip.close();
	}
	
		
private static boolean isValidText(String text) {
	for(int i=0;i<text.length();i++) {
		
		if(!Character.isDigit(text.charAt(i))) {
			return false;
		}
	}
	return true;
}
}
