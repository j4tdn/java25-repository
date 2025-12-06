package view;

import java.util.Scanner;

import static util.ValidateUtils.*;

public class Ex01PhuongTrinhBacNhat {
	
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("=== Chương trình giải phương trình bậc nhất ax + b = 0 ===");
		try {
			int a = inputNumber("Nhập vào 1 số a: ", false);
			int b = inputNumber("Nhập vào 1 số b: ", true);
			
			System.out.println("Kết quả x = " + ((double)-b/(double)a));
		} catch (ArithmeticException | NumberFormatException e) {
			e.printStackTrace();
		} finally {
			System.out.println("=== Kết thúc chương trình ===");
			ip.close();
		}
	}
	
	private static int inputNumber(String message, boolean allowZero) {
		String text = null;
		int number = 0;
		do {
			System.out.print(message);
			text = ip.nextLine();
			if(isValidNumber(text)) {
				number = Integer.parseInt(text);
				if(!allowZero && number == 0) {
					throw new ArithmeticException("Số nhập vào phải khác 0");
				} else {
					break;
				}
			} else {
				throw new NumberFormatException("Định dạng số không hợp lệ");
			}
		}
		while(true);
		
		return number;
	}
	
}
