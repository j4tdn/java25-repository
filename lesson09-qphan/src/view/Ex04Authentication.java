package view;

public class Ex04Authentication {
	
	public static void main(String[] args) {
		String username = "byztkhx256";
		String password = "ad@mInxaza2aa1k";
		
		try {
			System.out.println("Validate: " + validate(username, password));
		} catch (Exception e) {
			System.out.println(">>> " + e.getMessage());
		}
	}
	
	/**
	Yêu cầu mật khẩu như sau:
		1. Độ dài mật khẩu: >= 8
		2. Có ít nhất 1 chữ số, 1 kí tự in hoa, và một kí tự đặc biệt (~!@#$%^&*)
		3. Không được trùng quá 3 ký tự với tên tài khoản [Đăng ký khi bắt đầu chương trình]
	*/
	
	private static boolean validate(String username, String password) {
		if (password.length() < 8) {
			throw new IllegalArgumentException("Yêu cầu: Độ dài mật khẩu >= 8");
		}
		
		if (!password.matches("(?=.*[0-9])(?=.*[A-Z])(?=.*[~!@#$%^&*]).+")) {
			throw new IllegalArgumentException("Yêu cầu: Có ít nhất 1 chữ số, 1 kí tự in hoa, và một kí tự đặc biệt (~!@#$%^&*)");
		}
		
		if (isUsernameLetterOverlapping(username, password)) {
			throw new IllegalArgumentException("Không được trùng quá 3 ký tự với tên tài khoản [Đăng ký khi bắt đầu chương trình]");
		}
		
		return true;
	}
	
	private static boolean isUsernameLetterOverlapping(String username, String password) {
		int counter = 0;
		for (char pLetter: password.toCharArray()) {
			if (username.contains(String.valueOf(pLetter))) {
				counter++;
				if (counter > 3) {
					return true;
				}
			}
		}
		
		return false;
	}
	
}
