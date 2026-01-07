package view;

public class Ex03 {
	
	public static String revert(String s) {
		String res = "", word = "";
		boolean inword = false;
		for(int i = 0; i <= s.length(); i++) {
			char c = (i == s.length()) ? ' ' : s.charAt(i);
			
			if(c != ' ') {
				word += c;
				inword = true;
			} else if (inword) {
				if(res.length() > 0) res += " ";
				res += rev(word);
				word = "";
				inword = false;
						
			}
		}
		return res;
	}
	static String rev( String w) {
		String r = "";
		for(int i = w.length() - 1; i >= 0; i--) r += w.charAt(i);
		return r;
	}
	public static void main(String[] args) {
		System.out.println(revert("Welcome to JAVA10 class"));
	}
}
