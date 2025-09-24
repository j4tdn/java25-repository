package view;

public class Ex04StaticMethod {
	
	private int a;
	private int b;
	
	public Ex04StaticMethod(int a,int b) {
		this.a = a;
		this.b = b;
	}
	
	

	public static void main(String[] args) {
//		Ex04StaticMethod sm1 = new Ex04StaticMethod();
//		System.out.println("sm1: "+sm1.sum(1, 2));
//
//		Ex04StaticMethod sm2 = new Ex04StaticMethod();
//		System.out.println("sm1: "+sm2.sum(2, 2));
		
		
		Ex04StaticMethod sm1 = new Ex04StaticMethod(8, 2);
		System.out.println("sm1: "+sm1.sub());
//
//		Ex04StaticMethod sm2 = new Ex04StaticMethod();
//		System.out.println("sm1: "+sm2.sum(2, 2));
		
		
	}
	
	private int sub() {
		return a - b;
	}
	
	private static int sum(int a, int b) {
		return a + b;
	}

}
