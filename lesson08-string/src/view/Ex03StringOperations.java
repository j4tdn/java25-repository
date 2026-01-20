package view;

import java.util.Arrays;

public class Ex03StringOperations {

	public static void main(String[] args) {

		String s = "Grid";
		String s1 = "Layout. This a type of layout in Java Swing language";

		// 1. Tinh chieu ddai s

		System.out.println("Chieu dai s: " + s.length());

		// 2. Noi chuoi s1 vao s

		s = s + " " + s1;
		System.out.println("s: " + s);

		// 3. Lay 1 ky tu tai vi tri inex(3) trong chuoi s

		System.out.println("Vi tri thu 3: " + s.charAt(3));

		// 4. Duyet tung ki tu sau do in ra moi ki tu trong moi hang
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}

		// 5. Duyet va in ra tung tu trong chuoi, biet rang cac tu cach nhau boi khoang
		// trnag
		System.out.println("Cach 1");
		String[] words = s.split("[ \\.]+");
		for (String word : words) {
			System.out.println(word);
		}

		System.out.println();

		System.out.println("Cach 2");
		s = s.replaceAll("[ \\.]+", " ").strip();
		System.out.println("s cach 2\n" + s);
		int startIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (letter == ' ') {
				String word = s.substring(startIndex, i);
				System.out.println(word.trim());
				startIndex = i++;
			}
		}
		// 6. Tim vi tri xuat hien dau tien, cuoi cung cua ki tu 'a' trong chuoi s
		System.out.println(s.indexOf("a"));
		System.out.println(s.lastIndexOf("a"));
		
		String[] words1 = printWords("   Grid  Layout. This  a type of layout in Java Swing language");
		System.out.println(words1);
		
	}

	private static String[] printWords(String s) {
	    if (s == null || s.isBlank()) {
	        return null;
	    }

	    int count = 0;
	    // Khởi tạo mảng có kích thước tối đa bằng độ dài chuỗi (an toàn nhưng có thể dư thừa)
	    String[] words = new String[s.length()];
	    String word = "";

	    for (int i = 0; i < s.length(); i++) {
	        char letter = s.charAt(i);
	        // Cần có hàm isLetter() hoặc dùng Character.isLetter(letter)
	        if (isLetter(letter)) {
	            word = word + letter;
	        } else {
	            if (!word.isEmpty()) {
	                words[count++] = word;
	                word = "";
	            }
	        }
	    }

	    // Xử lý từ cuối cùng nếu chuỗi không kết thúc bằng ký tự đặc biệt
	    if (!word.isEmpty()) {
	        words[count++] = word;
	    }

	    // Cắt mảng để loại bỏ các phần tử null thừa ở cuối
	    return Arrays.copyOfRange(words, 0, count);
	}

	private static boolean isLetter(char c) {
		return Character.isLetter(c);
	}

	// Giả định hàm kiểm tra trạng thái đang trong từ
	// Trong code gốc có comment: begin = -1 là chưa start word
	private static boolean isInWord(Integer begin) {
		return begin != null && begin != -1;
	}
}
