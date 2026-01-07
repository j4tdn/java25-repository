package ex04;

public class Account {
	public static void main(String[] args) {
		String username = "byztkhx256";
		String password = "admin123";
		
		System.out.println(isValidPassword(username, password) ? "Dang ky tai khoan thanh cong" : "Mat khau khong hop le");
	}
	
	private static boolean isValidPassword(String username, String password) {
		if (password.length() < 8) return false;
		boolean digit = false;
		boolean upper = false;
		
		
		for(char c : password.toCharArray()) {
			if (Character.isDigit(c)) digit = true;
			if (Character.isUpperCase(c)) upper = true;
		}
		
		return digit && upper;
		
	}
	
	


}
