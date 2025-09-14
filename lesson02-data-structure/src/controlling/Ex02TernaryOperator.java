package controlling;

import java.util.Random;

public class Ex02TernaryOperator {

	public static void main(String[] args) {
		
		Random rd = new Random();
		int val = rd.nextInt();
		
		System.out.println("Giá trị: " + val);
		if(val % 2 == 0) {
			System.out.println("Giá trị random là số chẵn");
		} else {
			System.out.println("Giá trị random là số lẻ");
		}
		
		System.out.println("Giá trị random là số " + ((val % 2 == 0) ? "chẵn" : "lẻ"));
		
		int a = rd.nextInt(20);
		int b = rd.nextInt(20);
		int c = rd.nextInt(20);
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
		int max1 = (a > b) ? a : b;
		System.out.println("Giá trị lớn nhất của 2 số a, b: " + max1);
		
		int max2 = (a > b ? a : b) > c ? (a > b ? a : b) : c;
		System.out.println("Giá trị lớn nhất của 3 số a, b và c: " + max2);
		
		float point = 6.8f;
		
		
	}
	
}
