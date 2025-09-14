package homework;

import java.util.Scanner;

public class BT8 {

	/*
	 * Viết chương trình(hàm) kiểm tra số nguyên N có phải là số nguyên tố hay không
 	Biết rằng N là số nguyên dương được nhập từ bàn phím, bắt buộc nhập lại nếu N không hợp lệ
	(tối đa 5 lần) hoặc khai báo biến có sẵn giá trị hợp lệ
	
	VD: Nhập N = abc → báo lỗi, yêu cầu nhập lại
			   = 4 → false
			   = 7 → true
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
		
		if(number==2) {
			System.out.println(number + " là Số nguyên tố ");
		}
		else { if(SNT(number)) {
			System.out.println(number + " là Số nguyên tố");
		}
		else {
			System.out.println(number + " không phải là Số nguyên tố");
		}
			
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
		

private static boolean SNT(int n) {
	
	
	for(int i =2; i<=Math.sqrt(n);i++) {
		if(n%i==0 ) {
			return false;
			}
	
	}
			return true;
		
	}

}

