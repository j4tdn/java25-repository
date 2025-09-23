package view;

public class Ex04StaticMethod {
	//attribute
	private int a;
	private int b;
	public Ex04StaticMethod(int a, int b) {
		this.a =a;
		this.b =b;
	}
	public static void main(String[] args) {
		
		
		System.out.println("sm1: "+Ex04StaticMethod.sum(1, 2));
		
		
		System.out.println("sm2: "+Ex04StaticMethod.sum(2, 2));
		Ex04StaticMethod sm3 = new Ex04StaticMethod(3,2);
		System.out.println("sm3: "+sm3.sub());
		

	}
		// hàm sum k phụ thuộc vào đối tượng đang gọi mà nó phụ thuộc tham số truyền vào
		private static int sum(int a, int b) {
			return a+b;
		}
		
		private int sub() {
			return a-b;
		}
}
