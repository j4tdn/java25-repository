package view;

import java.util.Arrays;

public class Ex03StringOperations {

	public static void main(String[] args) {

		String s = "Grid";
		String s1 = "Layout. This is a type of layout in Java Swing Language";

		// 1. Tinh chieu dai cua chuoi s
		System.out.println("Length of s: " + s.length());

		// 2. Noi chuoi s1 vao chuoi s, in ra ket qua (luu y khong lam thay doi gia tri
		// cua s va s1)
		System.out.println("chuoi moi: " + s1.concat(s));

		// 3. Lay mot ky tu tai vi tri index(3) trong chuoi s
		System.out.println("ky tai vi tri index(3): " + s.charAt(3));

		// 4. Duyet tung ki tu sau do in ra moi ki tu trong moi hang
		for (Character item : s.toCharArray()) {
			System.out.println(item);
		}

		// 5. Duyện và in ra từng từ trong chuỗi, biết rằng các từ cách nhau bởi khoảng
		// trắng
		String[] words = s.split("\\s+");
		for (String word : words) {
			System.out.println(word);
		}

		int indexOf = -1;
		for (int i = 0; i < s1.length(); ++i) {
			char letter = s1.charAt(i);
			if (indexOf == -1 && Character.isLetter(letter)) {
				indexOf = i;
			}
			if (Character.isLetter(letter) && indexOf != -1) {
				indexOf = i;
			} else if (indexOf != -1) {
				String word = s1.substring(indexOf, i);
				System.out.println(word);
				indexOf = -1;
			}
		}

		// 6. Tìm vị trí(chỉ số) xuất hiện đầu tiên, cuối cùng của kí tự 'a' trong chuỗi
		// s
		System.out.println("Vi tri dau tien cua ki tu a: " + s.indexOf('a'));
		System.out.println("Vi tri cuoi cung cua ki tu a: " + s.lastIndexOf('a'));
	}

	private static String[] printWords(String s) {
		if (s == null || s.isBlank()) {
			return null;
		}

		int begin = 0;
		
		String[] words = new String[s.length()];
		
		int count = 0;
		
		String word = "";
		for (int i = 0; i < s.length(); ++i) {
			char letter = s.charAt(i);
			if (isLetter(letter)) {
//				if(!isInWord(begin)) {
//					begin = i;
//				}
				word += letter;
			}else {
//				if(isInWord(begin)) {
//					String word = s.substring(begin,i);
//					System.out.println("|||" + word + "|||");
//					words[count++] = s.substring(begin,i);
//					begin = -1;
//				}
				
				if(!word.isEmpty()) {
					words[count++] = word;
					word = "";
				}
			}
		}
		
//		if(isInWord(begin)) {
//			String word = s.substring(begin, s.length());
//			System.out.println(word);
//			words[count++] = s.substring(begin,s.length());
//		}
		
		if(!word.isEmpty()) {
			words[count++] = word;
		}
		
		return Arrays.copyOfRange(words, 0, count);
	}
	
	private static boolean isInWord(Integer begin) {
		return begin != null && begin != -1;
	}

	private static boolean isLetter(char letter) {
		return Character.isLetter(letter) || Character.isDigit(letter);
	}

}
