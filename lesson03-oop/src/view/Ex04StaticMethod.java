package view;

public class Ex04StaticMethod {

	// attribute
	private int a;
	private int b;

	// constructor
	public Ex04StaticMethod(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		System.out.println("sm1: " + Ex04StaticMethod.sum(1, 2));
		System.out.println("sm2: " + Ex04StaticMethod.sum(2, 2));

		Ex04StaticMethod sm3 = new Ex04StaticMethod(8, 2);
		System.out.println("sm3 sub: " + sm3.sub());

		Ex04StaticMethod sm4 = new Ex04StaticMethod(5, 1);
		System.out.println("sm3 sub: " + sm4.sub());

	}

	// khai bao mot ham sub de tinh hieu cua 2 so a, b
	// muon: phu thuoc vao doi tuong dang goi

	// kq hàm sub phụ thuộc vào tham số a, b
	// biến 2 tham số a và b trở thành thuộc tính của class Ex04StaticMethod
	// cứ 1 lần khởi tạo đối tượng mới thì đt sẽ lưu trữ a, b mới

	public int sub() {
		return a - b;
	}

	// ham sum khong phu thuoc vao doi tuong dang goi --> static
	private static int sum(int a, int b) {
		return a + b;
	}

}
