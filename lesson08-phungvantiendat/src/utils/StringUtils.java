package utils;

import java.text.Normalizer;
import java.util.regex.Pattern;
import static java.text.Normalizer.*;

public class StringUtils {

	private static final Pattern LETTER_SPACE = Pattern.compile("^[\\p{L}\\p{M} ]+$");
	private static final Pattern HAS_DIACRITIC = Pattern.compile(".*(\\p{M}|[Đđ]).*");

	public static boolean isValidString(String s) {
		if (s == null || s.isBlank()) {
			return false;
		}

		String n = Normalizer.normalize(s, Normalizer.Form.NFD);

		if (n.trim().isEmpty()) {
			return false;
		}
		return LETTER_SPACE.matcher(n).matches() && HAS_DIACRITIC.matcher(n).matches();
	}
	
	

	public static void printCharacter(String s) {
		System.out.println("----- Character ------");
		for (char c : s.toCharArray()) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	public static void printWords(String s) {
		String[] wordArr = s.split("\\s+");
		for (String it : wordArr) {
			System.out.println(it);
		}
	}

	public static void printReverseCharacter(String s) {
		for (int i = s.length() - 1; i >= 0; --i) {
			System.out.print(s.charAt(i));
		}
		System.out.println();
	}

	public static void printReverseWord(String s) {
		String[] wordArr = s.split("\\s+");
		for (int i = wordArr.length - 1; i >= 0; --i) {
			System.out.print(wordArr[i] +" ");
		}
		System.out.println();
	}
	
	public static String normalizeCaptitalCase(String s) {
//		String res = "";
		String[] wordArr = s.split("\\s+");
//		for(String it : wordArr) {
//			res+=Character.toUpperCase(it.charAt(0));
//			for(int i = 1;i<it.length();++i) {
//				res+=Character.toLowerCase(it.charAt(i));
//			}
//			res+=" ";
//		}
//		return res.trim();
		
		StringBuilder res = new StringBuilder();
		
		for(int i = 0;i<wordArr.length;++i) {
			String it = wordArr[i];
			res.append(it.substring(0,1).toUpperCase());
			if(it.length() > 1) {
				res.append(it.substring(1).toLowerCase());
				res.append(" ");
			}
		}
		
		return res.toString().trim();
	}
	
	public static String transformWithoutCombiningMark(String s) {
		String result = normalize(s, Form.NFD).replaceAll("\\p{M}", "").replace("Đ", "D").replace("đ", "d");
		return result;
	}
}
