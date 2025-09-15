package controlling;

import java.util.Random;

public class Ex02TernaryOperator {
	public static void main(String[] args) {
		/*
		  if ( expression){
		  statements if exp is true
		  } else {
		  statements if exp is false
		  }
		  
		  Toán tử 3 ngôi: (expression) ? statements(1) : statements(2)
		  			      (expression) ? return_data(1) : return_data(2)
		 
		 */
		Random rd = new Random();
		int val = rd.nextInt();

		System.out.println("Giá trị: " + val);
		if (val % 2 == 0) {
			System.out.println("Giá trị random là số chẵn");
		} else {
			System.out.println("Giá trị random là số lẽ");
		}
		
		// Toán tử 3 ngôi
		String result = (val % 2 == 0) ? "chẵn" : "lẽ";
		System.out.println("Giá trị random là số " + result);
		
		//hoặc rút ngắn hơn
		System.out.println("Giá trị random là số " + ((val % 2 == 0) ? "chẵn" : "lẽ"));
		
		// bài toán tìm số lớn nhất trong 3 số
		int a = rd.nextInt(20);
		int b = rd.nextInt(20);
		int c = rd.nextInt(20);
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
		int max1 = (a > b)? a : b;
		int max2 = (max1 > c)? max1 : c;
		
		System.out.println("Giá trị lớn nhất của 2 số a, b: " + max1);
		System.out.println("Giá trị lớn nhất của 3 số a, b, c: " + max2);
		
		// dùng toán tử 3 ngôi để xử lý bài toán random điểm trung bình từ 0:10, phần thập phân 1 chữ số và có khung điểm xếp loại
		
		float point = 6.8f;
		String ranking = (point < 5f) ? "Yếu" : point < 6.5f ? "Trung bình" : point < 8f ? "Khá" : "Giỏi";
		System.out.println("Học lực: " + ranking);
	}

}
