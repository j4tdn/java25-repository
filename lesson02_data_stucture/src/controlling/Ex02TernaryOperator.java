package controlling;

import java.util.Random;

public class Ex02TernaryOperator {
	public static void main(String[] args) {
		/*
		 *  if (expression) {
		 *     statements if exp is true
		 *  } else {
		 *     staements if exp is fasle
		 *  }
		 *  
		 *  Toán tử 3 ngôi: (expression) ? statements(1) : statements(1)
		 *                  (expression) ? return_data(1) : return_data(2)
		 *                  
		 */
		
		Random rd = new Random();
		int val = rd.nextInt();
		
		System.out.println("gia tri :" + val );
		if (val % 2 == 0) {
			System.out.println("gia tri random la so chan");
		} else {
			System.out.println("gia tri random la so le");
		}
		
		String result = (val % 2 == 0) ? "chan" : "le";
		System.out.println("toan tu 3 ngoi gia tri random la so" + result);
		
		int a = rd.nextInt(20);
		int b = rd.nextInt(20);
		int c = rd.nextInt(20);
		
		System.out.println("a :" + a);
		System.out.println("b :" + b);
		System.out.println("c :" + c);
		
		int max1 = (a > b) ? a : b;
		int max2 = max1 > c ? max1 : c;
		System.out.println("gia tri lon nhat cua a,b :" + max1);
		System.out.println("gia tri lon nhat cua a,b,c :" + max2);
		
		float point = 6.8f;
		String ranking = point < 5 ? "yeu" 
				                   : point < 6.5f ? "trung binh"
				                                 : point < 8f ? "kha" : "gioi";
		System.out.println("hoc luc :" + ranking);
        
        
		
	}

}
