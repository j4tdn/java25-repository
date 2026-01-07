package ex03;

public class revert {
	
	public static String reverts(String s) {
		s = s.trim();
		return new StringBuilder(s).reverse().toString();
	}
	
	public static void main(String[] args) {
		String i = "Welcome to JAVA10 class";
		System.out.println(reverts(i));
	}

}
