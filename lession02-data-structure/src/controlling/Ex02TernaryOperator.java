package controlling;

import java.util.Random;

public class Ex02TernaryOperator {
	public static void main(String[] args) {
		
		Random rd = new Random();
		int val = rd.nextInt();
				
		System.out.println("giá trị: " + val);
		if(val %2 == 0) {
			System.out.println("gía trị random là số chẵn");
		} else {
			System.out.println("gía trị random là số lẻ");
		}
		
		System.out.println("[Toán tử 3 ngôi]giá trị random là số " + ((val % 2 == 0) ? "chẵn" : "lẻ"));
		
		int a = rd.nextInt(20);
		int b = rd.nextInt(20);
		int c = rd.nextInt(20);
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
		int max1 = (a > b) ? a : b;
		int max2 = max1 > c ? max1 : c;	
		
		System.out.println("Giá trị lớn nhất của 2 số a, b: " + max1);
		System.out.println("Giá trị lớn nhất của 3  số a, b, c: " + max2);
		
		float point = 2.4f;
		String ranking = point < 5 ? "yếu" : point < 6.5f ? "trung bình " : point < 8f ? "khá" :"giỏi";
		System.out.println("học lực: " + ranking);
	}
}
