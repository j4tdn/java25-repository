package view;

public class Ex05Throw {

	// Bai toan
	// Viet ham thuc hien phep chia 2 so
	
	public static void main(String[] args) {
		
		System.out.println("=== Bat dau ===\n");
		
		// TH1: validated
		System.out.println("Ket qua 1: " + div(8,2));
		
		// TH2: not validate yet
		try {
			System.out.println("Ket qua 2: " + div(8,0));
		} catch (ArithmeticException e) {
			System.out.println("TH2: " + e.getMessage());
		}
		
		System.out.println("=== Ket thuc ===\n");
		
	}
	
	/*
	  Nguyen nhan ham div co the xay ra exception
	  --> Mau so b = 0: tham so nhan tu ben ngoai truyen vao
	  
	  TH1: neu ben ngoai(cho goi ham) da xu ly viec nhap vao mau so b luon != 0(validate)
	  		khi goi ham div, k bao gio xay ra exception
	  		try/catch ben trong ham --> thua
	  		
	  TH2: neu ben ngoai(cho goi ham) chua co validate cho mau so b
	  		khi goi ham div, van co the xay ra exception
	  		try/catch hop ly
	 */
	
	private static int div(int a, int b) {
		if(b == 0) {
			throw new ArithmeticException("Nhap mau != 0");
		}
		return a / b;
	}
	
}
