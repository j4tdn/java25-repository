package ex03;

public class ReverseString {
	public static void main(String[] args) {
		String input ="Welcome to JAVA10 class";
		
		System.out.println("Input:	"+input);
		System.out.print("Output:	");
		System.out.println(reverse(input));
	}
	
	public static String reverse(String s) {
		s = s.trim().replaceAll("\\s+"," ");
		
		String[] words = s.split(" ");
		
		StringBuilder output = new StringBuilder();
		for(String word:words) {
			output.append(new StringBuilder(word).reverse()).append(" ");
		}
	
		return output.toString().trim();
		
	}
	
	
}
