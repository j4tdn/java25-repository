package view;

public class Ex04StaticMethod {
	
	// attribute 
	private int a;
	private int b;
	
	// constructor
	public Ex04StaticMethod(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public static void main(String[] args) {
//		Ex04StaticMethod sm1 = new Ex04StaticMethod();
//		System.out.println("sm1: " + sm1.sum(1, 2));
		
		System.out.println("sm2: " + Ex04StaticMethod.sum(1, 2));
		
		Ex04StaticMethod sm3 = new Ex04StaticMethod(5, 1);
		System.out.println("sm3: " + sm3.sub());
	}
	
	// Khai bao ham sub phu thuoc vao doi tuong dang goi
	
	// kq ham sub phu thuoc vao tham so a, b
	// bien 2 tham so a,b tro thanh tt cua class Ex04StaticMethod
	// cu moi lan khoi tao doi tuong moi thi doi tuong do se luu tru a, b moi
	public int sub() {
		return a - b;
	}
	
	// ham sum k phu thuoc vao doi tuong dang goi --> static
	private static int sum(int a, int b) {
		return a + b;
	}
	
}
