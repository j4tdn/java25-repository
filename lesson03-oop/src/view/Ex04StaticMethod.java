package view;

public class Ex04StaticMethod {
	
	private int a;
	private int b;
	
	public Ex04StaticMethod(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		
		Ex04StaticMethod sm3 = new Ex04StaticMethod(8, 2);
		System.out.println("sm3 sub: " + sm3.sub());
		
		Ex04StaticMethod sm4 = new Ex04StaticMethod(5, 1);
		System.out.println("sm4 sub: " + sm4.sub());
		
	}
	
	// khai báo hàm sub phụ thuộc vào object đang gọi
	private int sub() {
		return this.a - this.b;
	}
	
	// ko phụ thuộc vào object đang gọi --> static
	private static int sum(int a, int b) {
		return a + b;
	}
	
}
