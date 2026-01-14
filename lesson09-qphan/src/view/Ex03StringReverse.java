package view;

public class Ex03StringReverse {
	
	public static void main(String[] args) {
		System.out.println(reverse("Welcome to Java25 class"));
	}
	
	private static String reverse(String s) {
		String[] tokens = s.strip().split("\\s+");
		String[] target = new String[tokens.length];
		int counter = 0;
		for (String token: tokens) {
			target[counter++] = new StringBuilder(token).reverse().toString(); 
		}
		return String.join(" ", target);
	}
	
}
