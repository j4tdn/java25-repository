package view;

public class Ex04 {
	public static void main(String[] args) {
		
		
	}
	
	private static String text(String s) {
		if (!TextOfChar(s)) {
			throw new IllegalArgumentException("Độ dài mật khẩu: >= 8");
			
		}
		if (!Alpha(s)) {
			throw new IllegalArgumentException("Co it nhat 1 ki tu hoa");
		}
		if (!NumSpecial(s)) {
			throw new IllegalArgumentException("Co it nhat mot chu so hoac ki tu");
			
		}
		return s;
	}
	
	private static boolean NumSpecial(String s) {
		boolean num = false;
		boolean special = false;
		
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				num = true;
			}
			if (!Character.isLetterOrDigit(c)) {
				special = true;
			}
			
			if (num && special) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean Alpha(String s) {
		boolean upper = false;
		
		for (char c : s.toCharArray()) {
			if (Character.isUpperCase(c)) {
				upper = true;
			}
		}
		return false;
	}
	
	private static boolean TextOfChar(String s) {
		return s.length() >= 8;
	}

}
