package homework;

import java.util.Random;

public class BT4 {
	/*
	 * Viết chương trình tính tổng giai thừa của các số nguyên dương S = a! +b! + c! + d!
	Biết rằng a,b,c,d là các số nguyên ngẫu nhiên từ 10 đến 20 → [10, 20]
	 */
	public static void main(String[] args) {
		
		Random rd = new Random();
		int a= rd.nextInt(10,21);
		int b= rd.nextInt(10,21);
		int c= rd.nextInt(10,21);
		int d= rd.nextInt(10,21);
		 long Total;
		System.out.print("a là: "+a +"\n");
		System.out.print("b là: "+b +"\n");
		System.out.print("c là: "+c +"\n");
		System.out.print("d là: "+d +"\n");
		Total = Checkgiaithua(a)+Checkgiaithua(b)+Checkgiaithua(c)+Checkgiaithua(d);
		System.out.println("Tổng giai thừa là: " +Total);
		
	}
	
	private static long Checkgiaithua(int n) {
		long result=1;
		while(n>1) {
			result = result*n;
			n--;
		}
		return result;
	}
}
