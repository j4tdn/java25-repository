package homework;

import java.util.Scanner;

public class Ex06SoNguyenNhoNhatTrong3ChuSo {
	
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		
		int a = inputNumber(0, 20, 5, "Nhâp a[0,20): ");
		
		int b = inputNumber(0, 20, 5, "Nhâp b[0,20): ");
		
		int c = inputNumber(0, 20, 5, "Nhâp c[0,20): ");
		
		System.out.println("Số lớn nhất là " + Math.max(a, Math.max(b, c)));
		
	}
	
	public static int inputNumber(int minInclusive, 
			int maxExclusive, int maxWrongTimes, String message) 
	{
		String text = null;
		int number = 0;
		int max = 0;
		while(true) {
			System.out.print(message);
			text = ip.nextLine();
			if(isNumber(text, minInclusive, maxExclusive)) {
				number = Integer.parseInt(text);
				break;
			}
			max++;
			System.out.println("Bạn đã nhập sai " + max + " lần");
			if(max == maxWrongTimes) {
				System.out.println("Bạn đã hết số lần nhập");
				return -1;
			}
		}
		return number;
	}
	
	public static boolean isNumber(String text, int minValue,int maxValue) {
		return Ex01BoiCua2.isValidNumber(text) 
				&& Integer.parseInt(text) >= minValue 
					&& Integer.parseInt(text) < maxValue ;
	}
	
}
