package controlling;

import java.util.Random;

public class Ex02TernaryOperator {
	
	public static void main(String[] args) {
		/*
		 if (expression) {
		 	statements if exp is true
		 } else {
		 	statements if exp is false
		 }
		 
		 Toán tử 3 ngôi: (expression) ? statements(1) : statements(1)
		                 (expression) ? return_data(1) : return_data(2)
		 */
		
		Random rd = new Random();
		int val = rd.nextInt();
		
		System.out.println("Giá trị: " + val);
		if (val % 2 == 0) {
			System.out.println("Giá trị random là số chẵn");
		} else {
			System.out.println("Giá trị random là số lẻ");
		}
		
		System.out.println("[Toán tử 3 ngôi]Giá trị random là số " + ((val % 2 == 0) ? "chẵn" : "lẻ"));
		
		int a = rd.nextInt(20);
		int b = rd.nextInt(20);
		int c = rd.nextInt(20);
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
		int max1 = (a > b) ? a : b;
		int max2 = (a > b ? a : b) > c ? (a > b ? a : b) : c;
		
		System.out.println("Giá trị lớn nhất của 2 số a, b: " + max1);
		System.out.println("Giá trị lớn nhất của 2 số a, b, c: " + max2);
		
		/*
		 Câu 3
		 ------
		 Random điểm trung bình(số thực) của học sinh [0.0, 10.0) phần thập phân có 1 chữ số
		 Nếu điểm mà
		 + [0, 5)   : Yếu
		 + [5, 6.5) : Trung Bình
		 + [6.5, 8) : Khá
		 + [8, 10]  : Giỏi
		 */
		float point = 2.4f;
		String ranking = point < 5 ? "Yếu" : point < 6.5f ? "Trung Bình" : point < 8f ? "Khá" : "Giỏi";
		System.out.println("Học lực: " + ranking);
		
	}
	
}
