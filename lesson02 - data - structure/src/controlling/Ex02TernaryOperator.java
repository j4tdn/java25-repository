package controlling;

import java.util.Random;

public class Ex02TernaryOperator {
	
	public static void main(String[] args) {
		/*
		 * Toán tử 3 ngôi(giống if): (expression) ? statement1:statement2
		 * 							 (expression) ? return data(1) : return data(2)
		 *  
		 */
	Random rd = new Random();
	int a = rd.nextInt(20);
	int b =rd.nextInt(20);
	int c=rd.nextInt(20);
	int max = (a>b) ? a : b;
	int max1 =(a>b ? a : b)> c ? (a>b ? a : b):c;
	System.out.println("max la: "+max+"," +a+","+ b);
	System.out.println("max1 la: " +max1+","+c);
	
	
	System.out.println("Ket qua chan le là: "+((a%2==0) ? "chẵn" : "lẽ"));
	
	//Câu 3 BT:
	
	int point = rd.nextInt(10);
	String ranking = point <5 ? "Yếu" : point<6.5 ? "Trung Bình" : point <8? "Khá" : "Giỏi";
	System.out.println("Học lực và điểm của HS là: "+point +", "+ranking);
	}
}
