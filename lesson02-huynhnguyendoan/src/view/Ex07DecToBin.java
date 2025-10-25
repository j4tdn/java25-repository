package view;

public class Ex07DecToBin {
	
	public static void main(String[] args) {
		int decimal = 7;
		
		System.out.println("binary = " + convert(decimal));
		
	}
	
	private static String convert(int decimal) {
		String binary = "";
		
		while(decimal != 0) {
			int mod = decimal % 2;
			binary = mod + binary;
			decimal /= 2;
		}
		
		return binary;
	}
	
}