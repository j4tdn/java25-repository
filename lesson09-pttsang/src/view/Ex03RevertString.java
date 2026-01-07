package view;

public class Ex03RevertString {
	public static void main(String[] args) {
		String text = "Welcome  to JAVA10 class";
		System.out.println("String -->" + text);
		System.out.println("Formatted -->" + revert(text));
		
	}
	
	private static String
	reserveCharacter(String s) {
		String result = "";
		for (int i = s.length() - 1; i>=0; i--) {
			result += s.charAt(i);
		}
		return result;
	}

	private static String revert(String s) {
		String [] ss = s.split("s");
		String result = "";
		for (String text:ss) {
			result += reserveCharacter(text) + "";
		}
		return result;
	}
	

}
