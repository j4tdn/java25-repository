package view;

public class Ex04StaticMethod {
	private int a;
	private int b;

	public Ex04StaticMethod(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		System.out.println("Sm1: " + Ex04StaticMethod.sum(2, 1));
		System.out.println("Sm2: " + Ex04StaticMethod.sum(2, 2));

		// Non-static
		Ex04StaticMethod sm3 = new Ex04StaticMethod(8, 2);
		System.out.println("sm3 sub: " + sm3.sub());

		Ex04StaticMethod sm4 = new Ex04StaticMethod(5, 1);
		System.out.println("sm4 sub: " + sm4.sub());

	}

	// KHia báo một hàm sub dùng để tính hiệu của hai số a và b
	// muốn hàm sub phụ thuộc vào đối tượng đang gọi

	// kq hàm sub phụ thuộc vào tham số a , b
	// biến 2 tham số a, b trở thành thuộc tính của class Ex04StaticMethod
	private int sub() {
		return a - b;
	}

	// Hàm sum không phụ thuộc vào đối tượng đang gọi --> static
	private static int sum(int a, int b) {
		return a + b;
	}

}
