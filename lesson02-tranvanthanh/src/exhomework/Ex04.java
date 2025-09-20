package exhomework;

import java.util.Random;

public class Ex04 {
		public static void main(String[] args) {
			Random rd = new  Random();
			int a = rd.nextInt(10)+10;
			int b = rd.nextInt(10)+10; 
			int c = rd.nextInt(10)+10; 
			int d = rd.nextInt(10)+10; 
			System.out.println("a= : "+ a);
			System.out.println("b= : "+ b);
			System.out.println("c= : "+ c);
			System.out.println("d= : "+ d);
		long S = factorial(a) + factorial(b) + factorial(c) + factorial(d);
        System.out.println("S= a! + b! +c! + d! = " + S);
    }

    private static long factorial(int n) {
        long temp = 1;
        for (int i = 1; i <= n; i++) {
            temp= temp* i;           
        }
        return temp;             
    }
}