package view;

public class Ex05Throw {

	public static void main(String[] args) {
		System.out.println("=== Bat dau chuong trinh ===\n");
		// TH1: Validated
		System.out.println("Ket qua TH1: " + div(8,2));
		
		// TH2: not validate yet
		try {
			System.out.println("Ket qua TH2: " + div(5,0));
		} catch (ArithmeticException ex) {
			System.out.println("TH2: "+ex.getMessage());
		}
		
		System.out.println("\n=== Ket thuc chuong trinh ===\n");
	}
	
	private static int div(int a, int b) {
		if(b == 0) {
			throw new ArithmeticException("Vui long truyen mau so != 0");
		}
		return a / b;
	}

}
