package datastructure.primitive;

public class Ex04PassVariablesViaMethod {
	private static int doCal(int a, int b) {
		int sum = a + b;
		int darg = sum * 2;
		int parg = darg * darg;
		return parg;

	}

	private static void modify(int e1) {
		int e2 = 77;
		e1 = 28;
		System.out.println(e2);
	}

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int ab = doCal(a, b);
		System.out.println(ab);
		int e1 = 5;
		int e2 = 7;
		modify(e1);
		System.out.println("e1:" + e1);
		System.out.println("e2:" + e2);
		System.out.println("================");
		modify(e2);
		System.out.println("e1:" + e1);
		System.out.println("e2:" + e2);
		System.out.printf("e1:(%d) và e2 :(%d)", e1, e2);

	}

}
