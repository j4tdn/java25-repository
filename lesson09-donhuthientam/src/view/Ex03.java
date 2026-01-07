package view;

public class Ex03 {
	public static void main(String[] args) {
		String s = "Welcome to JAVA10 class";
		
		System.out.println(revert(s));
		
	}
	private static String revert(String s) {
		String clean = remove(s);
		
		String result = "";
		String word = "";
		
		for (int i = 0; i < clean.length(); i++) {
			char c = clean.charAt(i);
			
			if (c != ' ') {
				word = c + word;
			} else {
				result += word + " ";
				word = "";
			}
		}
		result += word;
		return result;
	}
	private static String remove(String s) {
		String text = "";
		boolean check = false;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (c != ' ') {
				text += c;
				check = false;
				
			} else if (!check) {
				text += ' ';
				check = true;
			}
		}
		
		if( text.startsWith(" ")) {
			text = text.substring(1);
			
		}
		if (text.endsWith(" ")) {
			text = text.substring(0, text.length() - 1);
		}
		return text;
	}

}
