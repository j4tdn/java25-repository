package exercise;

import java.util.Scanner;

public class Ex06MinMax {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String sa;
		String sb;
		String sc;
		
		do {
			System.out.println("Nhap a");
			sa = ip.nextLine();
			if(isValid(sa)) break;
			System.out.println("Chua hop le");
		}
		while(true);
		
		do {
			System.out.println("Nhap b");
			sb = ip.nextLine();
			if(isValid(sb)) break;
			System.out.println("Chua hop le");
		}
		while(true);
		
		do {
			System.out.println("Nhap c");
			sc = ip.nextLine();
			if(isValid(sc)) break;
			System.out.println("Chua hop le");
		}
		while(true);
		System.out.println("Hop le");
		
		int a = Integer.parseInt(sa);
		int b = Integer.parseInt(sb);
		int c = Integer.parseInt(sc);
		
		Max(a, b, c);
		Min(a, b, c);
		
		ip.close();
	}
	
	private static boolean isValid(String text) {
		int number = Integer.parseInt(text);
		if(number > 20) return false;
		
		for(int i = 0; i < text.length(); i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	private static int Max(int a, int b, int c) {
		int max = ((a > b) ? a : b) > c ? ((a > b) ? a : b) : c;
		System.out.println("So lon nhat la: " + max);
		return max;
	}
	
	private static int Min(int a, int b, int c) {
		int min = ((a < b) ? a : b) < c ? ((a < b) ? a : b) : c;
		System.out.println("So nho nhat la: " + min);
		return min;
	}
	
}
