package view;

import java.util.Scanner;

public class Ex06IoValidation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text;
		int wrongtime = 3;
		do {
			System.out.printf("Hãy nhập vào một số nguyên: ");
			text = sc.nextLine();

			if (isValidText(text)) {
				int number = Integer.parseInt(text);
				if (number == 123) {
					System.out.println("Nhập đúng rồi: " + number);
					sc.close();
					break;
				} else {
					System.out.println("sai rồi");
				}
			}
			wrongtime--;
			System.out.printf("Số lần nhập còn %d\n", wrongtime);
			if (wrongtime == 0) {
				System.out.println("Bạn đã hết lượt nhập!");
				sc.close();
				return;
			}

		} while (true);

		sc.close();
	}

	private static boolean isValidText(String text) {

		for (int i = 0; i < text.length(); i++) {

			if (!Character.isDigit(text.charAt(i))) {
				System.out.println("Nhập sai rồi vui lòng nhập lại");
				return false;
			}

		}
		return true;

	}

}
