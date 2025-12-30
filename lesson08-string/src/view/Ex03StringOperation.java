package view;

import java.util.Arrays;

public class Ex03StringOperation {
	public static void main(String[] args) {
		String s = "Grid";
		String s1 = "Layout";

		// 1. Tính chiều dài của chuỗi s
		System.out.println("Chiều dài của chuỗi s: " + s.length());

		// 2. Nối chuỗi s1 vào chuỗi s --> lưu kết quả vào chuỗi s
		s = s + " " + s1; // s.concat("").concat(s1)
		System.out.println("Chuỗi sau khi nối: " + s);

		// 3. Lấy 1 ký tự tại vị trí index(3) trong chuỗi s
		char c = s.charAt(3);
		System.out.println("Ký tự tại index 3: " + c);

		// 4. Duyệt từng kí tự sau đó in ra mỗi kí tự trong mỗi hàng
		System.out.println("Các ký tự trong chuỗi:");
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}

		// 5. Duyệt và in ra từng từ trong chuỗi, biết rằng các từ cách khác nhau bởi
		// khoảng trắng
		System.out.println("Các từ trong chuỗi:");
		String[] words = s.split(" ");
		for (String word : words) {
			System.out.println(word);
		}

		// Cách code logic (không dùng hàm có sẵn trong java) Câu 5
		String[] words2 = printWords("#$%^& Grid 562())) Layout. This is a type of layout in Java Swing languag");
		System.out.println("\n5(words) --> " + Arrays.toString(words2));


		// 6. Tìm vị trí(chỉ số) xuất hiện đầu tiên, cuối cùng của kí tự 'a' trong chuỗi
		// s
		int firstIndex = s.indexOf('a');
		int lastIndex = s.lastIndexOf('a');
		System.out.println("Vị trí xuất hiện đầu tiên của 'a': " + firstIndex);
		System.out.println("Vị trí xuất hiện cuối cùng của 'a': " + lastIndex);

	}

	// Cách code logic (không dùng hàm có sẵn trong java) Câu 5
	private static String[] printWords(String s) {
	    if (s == null || s.isBlank()) {
	        return new String[0];
	    }
	    String[] words = new String[s.length()];
	    int count = 0;
	    int begin = -1;

	    for (int i = 0; i < s.length(); i++) {
	        char letter = s.charAt(i);

	        if (isLetter(letter)) {
	            if (!isInWord(begin)) {
	                begin = i;
	            }
	        } else {
	            if (isInWord(begin)) {
	                words[count++] = s.substring(begin, i);
	                begin = -1;
	            }
	        }
	    }

	    if (isInWord(begin)) {
	        words[count++] = s.substring(begin, s.length());
	    }

	    return Arrays.copyOfRange(words, 0, count);
	}
	private static boolean isInWord(int begin) {
	    return begin != -1;
	}
	private static boolean isLetter(char c) {
	    return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}


	
	


}
