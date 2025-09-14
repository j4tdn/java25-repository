package homework;

import java.util.Scanner;

public class BT5 {

	/*
	 * Viết chương trình kiểm tra N có phải là số đối xứng hay không
	Biết rằng N được nhập từ bàn phím là một số nguyên dương có tối thiểu 2 chữ số
	VD: Nhập N = abc → báo lỗi, yêu cầu nhập lại
	 a123 → báo lỗi, yêu cầu nhập lại
	= 1 → báo lỗi, yêu cầu nhập lại
	= 256 → false
	= 12521 → true
	= 2662 → true
	 */
public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		String text;
		
		int number=-1;
		do {
			System.out.print("Nhập vào 1 số nguyên: ");
			text = ip.nextLine();
			
			if (isValidText(text)) {
				 number = Integer.parseInt(text);
				if(number >9) {
					break;
				}
				
			}
			
			System.out.println("Chưa phải là số hợp lệ \n");
			
	
			
		} while (true);
		
		System.out.println("Số hợp lệ là: " + number);
		
		
			if(Doixung(number)) {
				System.out.println( number+" Đây là số đối xứng");
			}
			else {
				System.out.println(number+" Đây không là số đối xứng ");
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
private static boolean Doixung(long n) {
	long reverse=0;
	long temp =n;
	while(n>0) {
		reverse = reverse*10+ n%10;
		n=n/10;
		
	}
	if(reverse==temp) { return true;
			
	}
	return false;
}
	
}
