package datastructure.primitive;

public class Ex04PassVariableViaMethod {
	private static int a = 5;
	private static int b = 7;

	public static void main(String[] args) {
		int a1 = 2;
		int a2 = 3;
		int a12 = a1 + a2;
		int da12 = a12 * 2;
		int pa12 = da12 * da12;
		System.out.println("pa12: " + pa12);

		int b1 = 5;
		int b2 = 1;
		int b12 = b1 + b2;
		int db12 = b12 * 2;
		int pb12 = db12 * db12;
		System.out.println("pb12: " + pb12);
		
		int c1 = 3;
		int c2 = 2;
		int c12 = doCalc(c1, c2);
		System.out.println("c12: "+ c12);
		
		int e1 = 5;
		swap();
		
		System.out.println("a = "+ a +" b = " + b);
		modify(e1);
	}
	
	private static int doCalc(int arg1,int arg2) {
		int arg12 = arg1 + arg2;
		int darg = arg12 * 2;
		int parg = darg * 2;
		return parg;
	}
	
	private static void modify(int e1) {
		int e2 = 77;
		e1 = 28;
		int a = 5, b= 7;
	}
	
	private static void swap() {
		int tmp = a;
		a = b;
		b = tmp;
	}

}
