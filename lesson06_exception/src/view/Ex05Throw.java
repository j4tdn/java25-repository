package view;

public class Ex05Throw {
	
	//Bai toan
	//Viet ham thuc hien phep chia hai so nguyen
	
	
	public static void main(String[] args) {
		
		System.out.println("=== Bat dau chuong trinh ===\n");
		
		// TH1: Validated
		System.out.println("Ket qua: " + div(8, 2));
		
		//TH2: not validated yet
		try {
			System.out.println("Ket qua: TH2: " + div(5, 0));
			
		}catch (ArithmeticException e) {
			System.out.println("TH2: " + e.getMessage());
		}
		
		
		System.out.println("=== Ket thuc ===");
	}
	
	/*
	 * Nguyen nhan ham div co the xay ra exception
	 * -> Mau so b =0: tham so nhan tu ben ngoai truyen vao
	 * 
	 * TH1: nếu bên ngoài (chỗ gọi hàm) đã xử lý việc nhập vào mẫu số b luôn != 0(validate) 
	 * 		khi gọi hàm div, không bao giờ xảy ra exception 
	 * 		try/catch bên trong hàm --> thừa
	 * 
	 * TH2: nếu bên ngoài (chỗ gọi hàm) chưa có validate cho mẫu số b 
	 * 		khi gọi hàm div, vẫn có thể xảy ra exception
	 * 		try/catch hợp lý
	 * 
	 */
	
	
	private static int div(int a, int b) {
		if(b == 0 ) {
			throw new ArithmeticException("Vui long truyen mau so != 0");
		}
		return a/b;
	}
}
