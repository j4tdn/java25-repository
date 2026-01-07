package Ex03;

public class Remove {
	public static void main(String[] args) {
		String input = "Welcome to JAVA10 class";
		String output = revert(input);
		System.out.println("input: " + input);
		System.out.println("output: " + output);
	}
	public static String revert(String s) {
		s = s.trim().replace("\\s+ ", "");
		String[] words = s.split(" ");
		for(int i =0; i<words.length; i++) {
			words[i] = new StringBuilder(words[i]).reverse().toString();
		}
		StringBuilder result = new StringBuilder();
		for(int i =0; i<words.length; i++) {
			result.append(words[i]);
			if(i < words.length ) {
				result.append(" ");
			}
		}
		
		return result.toString();

	}
}
