package view;

import utils.InputUtils;

public class Ex05Symectric {
	
	public static void main(String[] args) {
		
		int number = InputUtils.inputNumberWithMin(9, 5);
		System.out.println("\n==================\n");
		System.out.println("Symectric A1 --> " + isSymetricNumber(number));
		System.out.println("Symectric A2 --> " + isSymectric(number));
	}
	
	// "12345", "159357", "25852"
	private static boolean isSymectric(int number) {
		String word = String.valueOf(number);
		int length = word.length();
		for (int i = 0; i < length; i++) {
			char letterIndex = word.charAt(i);
			char letterRevIndex = word.charAt(length - i - 1);
			if (letterIndex != letterRevIndex) {
				return false;
			}
		}
		return true;
	}
	
	// 123 --> 321
	// 232 --> 232
	private static boolean isSymetricNumber(int number) {
		return number == findSymetricValue(number);
	}
	
	private static int findSymetricValue(int number) {
		int reversed = 0;
		while(number > 0) {
			int unitVal = number % 10; // lấy chữ số hàng đơn vị(bên phải ngoài cùng)
			reversed = reversed*10 + unitVal; // giá trị của reversed
			number /= 10; // bỏ chữ số cuối cùng bên phải
		}
		return reversed;
	}
	
}