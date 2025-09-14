package controlling;

import java.util.Random;

public class Ex02TernaryOperator {
	public static void main(String[] args) {
		Random rd = new Random();
//		int a = rd.nextInt(20);
//		int b = rd.nextInt(20);
//		int c = rd.nextInt(20);
//		
//		int max1 = (a > b) ? a : b;
//		int max2 = max1 > c ? max1 : c;
//		
//		System.out.println("a: " + a);
//		System.out.println("b: " + b);
//		System.out.println("c: " + c);
//		
//		System.out.println("Gia tri lon nhat cua hai so a, b: "+ max1);
//		System.out.println("Gia tri lon nhat cua ba so a, b, c: "+ max2);
		
		double avgPoint = rd.nextDouble(10.0d);
		System.out.println("Avg Point: "+ avgPoint);
		String result = (avgPoint<5) ? "Yeu" : (avgPoint<6.5 ? "Trung Binh" : (avgPoint < 8 ? "Kha" : "Gioi"));
		System.out.println(result);
	}
}
