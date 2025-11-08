package view;

import java.util.Scanner;

public class FractionSimplified {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Float n = checkInput();
		String gmf = getMinFract(n);
		System.out.printf("phan so da toi gian cua %s la %s", n, gmf);
		
	}
	
	private static String getMinFract(Float n) {
		String s = Float.toString(n); 
		int digits = s.length() - s.indexOf('.')-1;
		
		int denominator  = (int) Math.pow(10, digits);
		int numerator  = (int) Math.round(n*denominator);
		
		int a = numerator;
		int b = denominator;
		
		while(b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		int st = a;
		
		numerator /= st;
		denominator /= st;
		
		return numerator + "/" + denominator;
	}
	
	private static Float checkInput() {
		Float n = null;
		String text = null;
		int count = 0;
		
		do {
			System.out.print("nhap n co 1 so thuc va phan thap phan khac khong : ");
			text = sc.nextLine();
			if(isFloatNumber(text)) {
				n = Float.parseFloat(text);
				break;
			}
			if(++count == 3) {
				System.out.println("qua so lan nhap, thoat ctrinh.");
				System.exit(0);
			}
		} while (true);
		return n;
		
	}
	
	
	private static boolean isFloatNumber(String text) {
		if (text == null ||text.isEmpty()) {
			return false;
		}
		return text.matches("-?\\d*\\.\\d*[1-9]\\d*");

	}

}
