package homework;

import java.util.Scanner;

public class BT1 {

		/*
		 * Viết chương trình(hàm) kiểm tra số nguyên N có phải là bội của 2 hay không
	Yêu cầu: N là số nguyên dương được nhập từ bàn phím, bắt buộc nhập lại nếu N không hợp lệ (tối
	đa 5 lần)
	VD: Nhập N = abc → báo lỗi, yêu cầu nhập lại

	= 4 → true
	= 6 → true
	= 7 → false
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
		
		if (number % 2 == 0) {
			System.out.println("true " + number + " là bội của 2");
		} else {

			System.out.println("false " + number + " không phải là bội của 2");
		}
		
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
