package view;


public class Ex02LargestNumbers {
	public static void main(String[] args) {
		
		String[] s1 = getLargestNumbers("01a2b3456cde478");
		Print(s1);
		String[] s2 = getLargestNumbers("aa6b546c6e22h", "aa6b326c6e22h");
		Print(s2);
	}
	
	private static String[] getLargestNumbers(String... string) {
		String[] result = new String[string.length];
		
		for (int i = 0; i < string.length; i++) {
			String max = "0";
			String cur = "";
			
			for (int j = 0; j < string[i].length(); j++) {
				char c = string[i].charAt(j);
				
				if (c >= '0' && c <= '9') {
					cur += c;
				} else {
					max = maxNumber(max, cur);
					cur = "";
				}
			}
			result[i] = maxNumber(max, cur);
			
		}
		
		sort(result);
		
		return result;
		
		
		
	}
	private static int compare(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return s1.length() - s2.length();
			
		}
		return s1.compareTo(s2);
	}
 
	private static String maxNumber(String s1, String s2) {
		if (s2.isEmpty()) {
			return s1;
		}
		s2 = zero(s2);
		if (s1.length() != s2.length()) {
			return s1.length() > s2.length() ? s1 : s2;
		}
		return s1.compareTo(s2) >= 0 ? s1 :s2;
 		
	}
	private static String zero(String s) {
		int i = 0;
		while (true) {
			if (i < s.length() -1 && s.charAt(i) == '0') {
				i++;
			}
			return s.substring(i);
		}
		
	}
	private static void sort(String[] s) {
		for (int i = 1; i < s.length; i++) {
			String result = s[i];
			int count = i - 1;
			
			while (count >= 0 && compare(s[count], result) > 0) {
					s[count + 1] = s[count];
					count --;
				s[count + 1] = result;
			}
		}
		
	}
	
	private static void Print(String[] s) {
		for (String text : s) {
			System.out.println(text + " ");
		}
		System.out.println();
	}
}
