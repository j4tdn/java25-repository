package view;

public class Ex05Throw {

	// Bài toán
	// Viết hàm thực hiện phép chia
	public static void main(String[] args) {
		System.out.println("Kết quả: " + div(8,2));
		
		// case not validated yet
		try {
			System.out.println("Kết quả th2: " + div(5,0));
		} catch (ArithmeticException e) {
			System.out.println("th2: " + e.getMessage());
		}
	}
	
	private static int div(int a, int b) {
		if(b == 0) {
			throw new ArithmeticException("Vui lòng truyền mẫu số khác 0");
		}
		return a / b;
	}
	
}
