package homework;

import java.util.Scanner;

public class BT3 {
	
	/*
	 * Bài 3: Viết chương trình tìm giai thừa của một số nguyên dương N
	Biết rằng: N có thể được nhập từ bàn phím hoặc khai báo sẵn

	Ví dụ: Nhập N = 1 → 1! = 1
	Nhập N = 5 → 5! = 5.4.3.2.1 = 120
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
		
		System.out.println("Giai thừa của " +number +"là: "+Checkgiaithua(number));
		
		
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
		
private static int Checkgiaithua(int n) {
	int result=1;
	while(n>1) {
		result = result*n;
		n--;
	}
	return result;
}

}
