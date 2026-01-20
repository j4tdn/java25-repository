package view;

import java.util.Arrays;

public class Ex06StringMutable {

	public static void main(String[] args) {
		
		// Lien quan den cap nhat gia tri cua 1 chuoi nhieu lan(xoa, them, sua chuoi)
		// Can nhac nen ddung mutable
		
		String[] words = printWords("   Grid  Layout. This  a type of layout in Java Swing language");
		System.out.println(Arrays.toString(words));
	}
	
	private static String[] printWords(String s) {
	    if (s == null || s.isBlank()) {
	        return null;
	    }

	    int count = 0;
	    // Khởi tạo mảng có kích thước tối đa bằng độ dài chuỗi (an toàn nhưng có thể dư thừa)
	    String[] words = new String[s.length()];
	   // String word = ""; // immutable
	    StringBuilder word = new StringBuilder(); // mutable
	    
	    for (int i = 0; i < s.length(); i++) {
	        char letter = s.charAt(i);
	        // Cần có hàm isLetter() hoặc dùng Character.isLetter(letter)
	        if (isLetter(letter)) {
	            word.append(letter);
	            System.out.println(System.identityHashCode(word));
	        } else {
	            if (!word.isEmpty()) {
	                words[count++] = word.toString();
	                word.delete(0, word.length()); // gan ve rong
	            }
	        }
	    }

	    // Xử lý từ cuối cùng nếu chuỗi không kết thúc bằng ký tự đặc biệt
	    if (!word.isEmpty()) {
	        words[count++] = word.toString();
	    }

	    // Cắt mảng để loại bỏ các phần tử null thừa ở cuối
	    return Arrays.copyOfRange(words, 0, count);
	}

	private static boolean isLetter(char c) {
		return Character.isLetter(c);
	}

	// Giả định hàm kiểm tra trạng thái đang trong từ
	// Trong code gốc có comment: begin = -1 là chưa start word
//	private static boolean isInWord(Integer begin) {
//		return begin != null && begin != -1;
//	}
}
