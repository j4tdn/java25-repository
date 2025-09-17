package view;

import java.util.Scanner;

public class Ex06IoValidation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// sc.nextLine() phải nhập kí tự số cho đúng
		String text;
		int wrongTime = 0;
		do {
			System.out.println("Nhap so nguyen: ");
			text = sc.nextLine();
			if (isValidText(text)) {
				break;
			}
			
			if (++wrongTime == 4) {
				System.out.println("nhap sai qua 3 lan, thoat!");
				sc.close();
				return;
			}
			System.out.printf("chua hop le (lan %s)\n\n", wrongTime);

		} while (true);
		int n = Integer.parseInt(text);
		System.out.println("Gtri hop le: " + n);
		sc.close();
	}

	private static boolean isValidText(String text) {
		boolean isValidText = true;
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
