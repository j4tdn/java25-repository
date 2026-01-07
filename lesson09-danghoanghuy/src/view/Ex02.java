package view;

import java.util.Scanner;

/*
 Bài 2(20đ):Cho n xâu chuỗi, mỗi chuỗi bao gồm các ký tự la tinh thường và chữ số. Đoạn các
ký tự số liên tục tạo thành một số nguyên. Ở mỗi xâu chuỗi trích ra các số nguyên và tìm số lớn
nhất, sắp xếp các số lớn nhất nhận được từ các xâu đã cho và in ra theo thứ tự không giảm, mỗi số
được đưa ra dưới dạng không có các số 0 không có nghĩa (024)
Nếu chuỗi rỗng hoặc chuỗi chỉ chứa các ký tự latinh thì số lớn nhất của chuỗi đó là 0
Ví dụ: với n = 1 : xâu 01a2b3456cde478 : Kết quả: 3456
với n = 2 : xâu aa6b546c6e22h, aa6b326c6e22h: Kết quả: 326, 546
Method signature: getLargestNumbers(String ...ss) >> String[]
 */

public class Ex02 {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhap n xau: ");
		int n  = ip.nextInt();
		ip.nextLine();
		
		while(n > 0) {
			System.out.println("Nhap xau: ");
			String s = ip.nextLine();
			getLargestNumbers(s);
			--n;
		}
		
		ip.close();
	}
	
	private static void getLargestNumbers(String s) {
	
		int maxPos = 0;
		int maxLen = 0;
		int n = s.length();
		
		int i = 0;
		
		while(i < n) {
			
			int start = i;
			char currentChar = s.charAt(i);
			
			while(Character.isDigit(currentChar)) {
				i++;
			}
			
			int currentLen = i - start;
			
			if(currentLen >= maxLen) {
				maxLen = currentLen;
				maxPos = start;
			}
		}
		
		System.out.println(s.substring(maxPos, maxPos + maxLen));
	}
	
}
