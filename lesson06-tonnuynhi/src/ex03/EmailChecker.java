package ex03;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailChecker {

	private static final Pattern PREFIX_PATTERN = Pattern.compile("^[A-Za-z0-9]+([._-][A-Za-z0-9]+)*$");

	private static final Pattern DOMAIN_PATTERN = Pattern.compile("^[A-Za-z0-9]+(\\.[A-Za-z0-9]+)+$");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Nhập địa chỉ email: ");
			String email = sc.nextLine();

			try {
				validateEmail(email);
				System.out.println("Email hợp lệ: " + email);
				break;
			} catch (InvalidEmailException e) {
				System.out.println("Email không hợp lệ: " + e.getMessage());
				System.out.println("Vui lòng nhập lại.\n");
			}
		}

		sc.close();
	}

	private static void validateEmail(String email) throws InvalidEmailException {
		if (email == null || email.isEmpty()) {
			throw new InvalidEmailException("Email không được để trống.");
		}

		int atIndex = email.indexOf('@');
		int lastAtIndex = email.lastIndexOf('@');

		if (atIndex <= 0 || atIndex != lastAtIndex || atIndex == email.length() - 1) {
			throw new InvalidEmailException("Email phải có đúng một ký tự '@' và không ở đầu/cuối.");
		}

		String prefix = email.substring(0, atIndex);
		String domain = email.substring(atIndex + 1);

		if (!PREFIX_PATTERN.matcher(prefix).matches()) {
			throw new InvalidEmailException("Phần prefix (trước '@') chỉ được chứa chữ, số, '_', '.', '-' "
					+ "và không được bắt đầu/kết thúc bằng '_', '.', '-' hoặc lặp các ký tự đặc biệt.");
		}

		if (!DOMAIN_PATTERN.matcher(domain).matches()) {
			throw new InvalidEmailException("Phần domain (sau '@') phải có dạng ví dụ: mail.com, abc.def.vn "
					+ "(chỉ chữ, số và dấu chấm, có ít nhất một dấu chấm).");
		}
	}

	private static class InvalidEmailException extends Exception {
		public InvalidEmailException(String message) {
			super(message);
		}
	}
}
