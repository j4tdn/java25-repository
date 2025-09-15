package nghoangminh_lesson02exercise;

import java.math.BigInteger;
import java.util.Random;

public class bai4 {
	public static void main(String[] args) {
		
	
	 Random random = new Random();

     // Random 4 số trong [10,20]
     int a = random.nextInt(11) + 10; // 10 → 20
     int b = random.nextInt(11) + 10;
     int c = random.nextInt(11) + 10;
     int d = random.nextInt(11) + 10;
     

     // Tính tổng S = a! + b! + c! + d!
     BigInteger Sa = factorial(a);
     BigInteger Sb = factorial(b);
     BigInteger Sc = factorial(c);
     BigInteger Sd = factorial(d);

     BigInteger S = Sa.add(Sb).add(Sc).add(Sd);

     // In kết quả
     System.out.println("Các số được random: a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
     System.out.println(a + "! = " + Sa);
     System.out.println(b + "! = " + Sb);
     System.out.println(c + "! = " + Sc);
     System.out.println(d + "! = " + Sd);
     System.out.println("Tổng S = a! + b! + c! + d! = " + S);
 }
	public static BigInteger factorial(int n) {
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
}
