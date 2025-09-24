package view;

public class Ex04StaticMethod {
	private int a;
	private int b;
	
	
	public Ex04StaticMethod(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public static void main(String[] args) {
		System.out.println("sm1: " + Ex04StaticMethod.sum(1, 2));

		System.out.println("sm2: " + Ex04StaticMethod.sum(2, 2));
		
		Ex04StaticMethod sm3 = new Ex04StaticMethod(8,2);
		System.out.println("sm3 sub: " + sm3.sub());
		Ex04StaticMethod sm4 = new Ex04StaticMethod(5,1);
		System.out.println("sm4 sub: " + sm3.sub());
	}
	private static int sum(int a, int b ) {
		return a + b;
	}
	private int sub() {
		return a - b;
	}
}
