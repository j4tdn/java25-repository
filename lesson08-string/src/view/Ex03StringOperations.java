package view;

public class Ex03StringOperations {
	
	public static void main(String[] args) {
		String s = "Grid";
		String s1 = "Layout. This a type of layout in Java Swing language";
		
		System.out.println("1. Tính chiều dài của chuỗi s: " + s.length());
		
		s = s + " " + s1; // concatenate s.concat(" ").concat(s1)
		System.out.println("2. Kết quả nối chuỗi: " + s);
		
		System.out.println("3. Lấy kí tự tại vị trí có index(3): " + s.charAt(3));
		
		System.out.println("4. Duyệt từng kí tự sau đó in ra mỗi kí tự trong mỗi hàng");
		for(int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		
		System.out.println("5. Duyệt và in ra từng từ trong chuỗi, biết rằng các từ cách nhau bởi khoảng trắng"); 
//		String[] words = s.split("[ \\.]+");
//		for (String word: words) {
//			System.out.println(word);
//		}
		
		//Grid Layout This a type of layout in Java Swing language
		s = s.replaceAll("[ \\.-]+", " ").strip();
		System.out.println("5. s(new) --> " + s);
		
		int startIndexOf = 0;
		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (letter == ' ') {
			 	String word = s.substring(startIndexOf, i);
			 	System.out.println(word.trim());
			 	startIndexOf = i++;
			}
		}
		
		// 6. Tìm vị trí(chỉ số) xuất hiện đầu tiên, cuối cùng của kí tự 'a' trong chuỗi s
		System.out.println("6. Vị trí xuất hiện đầu tiên của kí tự 'a' --> " + s.indexOf("a"));
		System.out.println("6. Vị trí xuất hiện cuối cùng của kí tự 'a' --> " + s.lastIndexOf("a"));
	}
	
	// Grid Layout This a type of layout in Jva Swing language
	private static void printWords(String s) {
		if(s == null || s.isBlank()) {
			return;
		}
		int begin = 0; // vị trí bắt đầu của mỗi từ (từ hiện tại)
		for(int i = 0; i< s.length(); i++) {
			char letter =  s.charAt(i);
			if(isLetter(letter)) {
				if(begin != -1) {
					continue;
				}else {
					
				}
			}else {
				
			}
		
		}
	}
	
	
	private static boolean isLetter(char letter) {
		return Character.isLetter(letter) || Character.isDigit(letter);
	}
	
}