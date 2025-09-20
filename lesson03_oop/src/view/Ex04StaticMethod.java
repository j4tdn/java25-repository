package view;

public class Ex04StaticMethod {
	private int a;
	private int b;
	
	
	
	public Ex04StaticMethod(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		
		
		System.out.println("sm1 :" + Ex04StaticMethod.sum(1, 2));
		
		System.out.println("sm1 :" + Ex04StaticMethod.sum(2, 2));
		
		Ex04StaticMethod sm3 = new Ex04StaticMethod(8,2);
		System.out.println("sm3 sub: " + sm3.sub());
		
		Ex04StaticMethod sm4 = new Ex04StaticMethod(5,2);
		System.out.println("sm4 sub: " + sm4.sub());
		
	}
	
	// khai báo 1 hàm sub dùng để tính hiệu của 2 số a và b phụ thuộc vào đối tượng đang gọi
	// kết quả hàm sub phụ thuộc vào tham số a, b
	// biến 2 tham số a, b trở thành thuộc tính của class Ex04StaticMethod
	// cứ mỗi lần khởi tạo đối tương mới thì tt đó sẽ lưu trữ a, b mới
	
	public int sub() {
		return a - b;
	}
	
	
	// ham sum ko phu thuoc vao doi tuong dang goi --> static
	private static int sum(int a, int b) {
		return a + b;
	}

}
