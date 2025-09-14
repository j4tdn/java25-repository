package homework;

import java.util.Scanner;

public class BT2 {

	/*
	 * Bài 2: Viết chương trình(hàm) kiểm tra số nguyên N có phải là lũy thừa của 2 hay không
 Biết rằng N là số nguyên dương được nhập từ bàn phím, bắt buộc nhập lại nếu N không hợp lệ
 (tối đa 5 lần) hoặc khai báo biến có sẵn giá trị hợp lệ
 VD: Nhập N = abc → báo lỗi, yêu cầu nhập lại

 = 4 → true
 = 6 → false
 = 8 → true
 = 9 → false
	 */
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		String text;
		int count =0;
		int number=-1;
		do {
			System.out.print("Nhập vào 1 số nguyên: ");
			text = ip.nextLine();
			if (isValidText(text)) {
				 number = Integer.parseInt(text);
				if(number >0) {
					break;
				}
				
			}
			
			System.out.println("Chưa phải là số hợp lệ \n");
			
			count++;
			if (count == 5) {
				System.out.println("Đã quá số lần nhập");
				return;
			}
		} while (true);
		
		System.out.println("Số hợp lệ là: " + number);
		
		if(Checkluythua(number)) {
			System.out.println(number + " là lũy thừa của 2");
		}else System.out.println(number + " không là lũy thừa của 2");
			
		
		
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
private static boolean Checkluythua(int n) {
	
	while(n%2==0) {
		n=n/2;
	}
	if(n==1) {
		return true;
	}else return false;
}
	
	
}
