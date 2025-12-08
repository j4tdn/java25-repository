package view;

import java.net.SocketTimeoutException;

public class Ex05Throw {
	
	public static void main(String[] args) {
		System.out.println("=== Bắt đầu chương trình ===\n");
		
		//th1: validate
		System.out.println("Kết quả th1: " + div(8, 2));
		
		//th2: not validate yet
		try {
			System.out.println("kết quả th2: " + div(5, 0));
		}catch(ArithmeticException e) {
			System.out.println("th2: " +e.getMessage());
		}
		
		System.out.println("=== kết thúc chương trình ===");
		
	}
	
	/*
	 * nguyên nhân hàm div có thể xảy ra exception
	 * --> mẫu số b = 0: tham số nhân từ bên ngoài truyền vào
	 * 
	 * th1: nếu bên ngoài đã xử lý việc nhập mẫu vào số b luôn khác 0
	 * 		khi gọi hàm div, không bao h xảy ra exception
	 * 		try/catch bên trong hàm --> thừa
	 * th2: nếu bên ngoài (chỗ gọi hàm) chưa có validate cho mẫu số b
	 * 		khi gọi hàm div, vẫn có thể xảy ra exception
	 * 		try/catch hợp lý
	 */
	private static int div (int a, int b) {
		if(b == 0) {
			throw new ArithmeticException("vui lòng truyền mẫu số != 0");
		}
		return a / b;
	}
}
