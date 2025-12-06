package assignments;

import java.util.Scanner;

import utils.EmailUtils;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String email = "";
		String prefix = "";
		do {
			try {
				System.out.println("Nhap email: ");
				email = sc.nextLine().trim();
				prefix = EmailUtils.getPrefixEmail(email);
				if(EmailUtils.isValidEmailPrefix(prefix)) {
					System.out.println("Email hop le. ");
					break;
				}
			} catch (RuntimeException ex) {
				System.out.println(ex.getMessage());
			}
		} while (true);

	}

}
