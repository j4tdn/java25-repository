package datastructure.primitive;

public class Ex04PassVariableViaMethod {
	
	public static void main(String[] args) {
		
		int a1 = 2;
		int a2 = 3;
		int a12 = a1 + a2;
		int da12 = a12 * 2;
		int pa12 = da12 *da12;
		System.out.println("pa12: " + pa12);
		
		
		
		int b1 = 5;
		int b2 = 1;
		int b12 = b1 + b2;
		int db12 = b12 * 2;
		int pb12 = db12 *db12;
		System.out.println("pb12: " + pb12);
		
		int c1 = 3;
		int c2 = 2;
		int c12 = doacalc(c1, c2);
		System.out.println("c12: " + c12);
		
		int d12 = doacalc(1, 5);
		System.out.println("d12: " + d12);
		
		int e1 = 5;
		int e2 = 7;
		System.out.println("e1: " + e1);
		System.out.println("e2: " + e2);
		
		modify(e1);
		
		System.out.println("e1: " + e1);
		System.out.println("e2: " + e2);
		
		modify(e2);
		
		System.out.println("e1: " + e1);
		System.out.println("e2: " + e2);
		
 	}
	private static void modify(int e1) {
		int e2 = 77;
		e1 = 28;
	}
	
	private static int doacalc(int arg1 , int arg2) {
		int arg12 = arg1 + arg2;
		int darg = arg12 * 2;
		int parg = darg * darg;
		return parg;
	}
}
