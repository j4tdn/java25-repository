package view;

public class Ex05Throw {
	
	public static void main(String[] args) {
		
		System.out.println("== Bat dau chuong trinh ==\n");
		
		System.out.println("Ket qua TH1: " + div(8, 2));
		
		try {
			System.out.println("Ket qua TH2: " + div(5, 0));
			
			
		} catch (ArithmeticException e) {
			System.out.println("th2: " + e.getMessage());
		}
		

		
		System.out.println("\n== Ket thuc ctrinh ==");
	}
	
	private static int div(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Vui long truyen mau so != 0");
		}
		return a / b;
	}

}
