package controlling;

import java.util.Random;

public class Ex02TernaryOperator {
	public static void main(String[] args) {
		/*
		 * if (expression) { statements if exp is true } else { statements if exp is
		 * false }
		 * 
		 * Toán tử 3 ngôi: (expression) ? statements(1) : statements(2) (expression) ?
		 * return_data(1) : return_data(2)
		 */

		Random rd = new Random();
		int val = rd.nextInt(1, 3);

		System.out.println("Giá trị: " + val);
		if (val % 2 == 0) {
			System.out.println("Giá trị random là số chẵn");
		} else {
			System.out.println("Giá trị random là số lẻ");
		}

		System.out.println("[Toán tử 3 ngôi] Giá trị random là số " + ((val % 2 == 0) ? "chẵn" : "lẻ"));

		int a = rd.nextInt(20);
		int b = rd.nextInt(20);
		int c = rd.nextInt(20);

		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);

		int max1 = (a > b) ? a : b;
		int max2 = max1 > c ? max1 : c;

		System.out.println("Giá trị lớn nhất giữa 2 số a và b là: " + max1);
		System.out.println("Giá trị lớn nhất giữa a số là: " + max2);
		Double score = rd.nextDouble(11);
		String s1 = (score < 5) ? "yếu"
				: (score < 6.5) ? "trung bình" : (score < 8.5) ? "Học sinh khá" : "học sinh giỏi";

		System.out.println("Số điểm của học sinh là: " + score);
		System.out.println(s1);

	}

}
