package exericise;

import java.util.Random;

public class Ex10 {
	public static void main(String[] args) {
		Random rd = new Random();
		
		int a, b, c, d, e;
		
		a = rd.nextInt(20, 30);
		do {
			
			b = rd.nextInt(20, 30);
		}while(b == a);
		do {
			
			c = rd.nextInt(20, 30);
		}while(c == a || c == b);
		do {
			
			d = rd.nextInt(20, 30);
		}while(d == a || d == b || d==c );
		do {
			
			e = rd.nextInt(20, 30);
		}while(e == a || e == b || e==c || e == d);
		System.out.println("5 so ngau nhien: ");
		System.out.print("gtri a: ");
        System.out.print(a);
        System.out.print("gtri b: ");
        System.out.print(b);
        System.out.print("gtri c: ");
        System.out.print(c);
        System.out.print("gtri d: ");
        System.out.print(d);
        System.out.print("gtri e: ");
        System.out.print(e);
		
	}
}
