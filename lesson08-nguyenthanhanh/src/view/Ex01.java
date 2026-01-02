package view;

import static utils.StringUtils.*;

public class Ex01 {

	public static void main(String[] args) {
		
		String text = null;
		try {
			text = inputString("Nhập vào 1 chuỗi: ", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// In ra mỗi kí tự trên một dòng
		for(int i = 0; i < text.length(); i++) {
			System.out.println(text.charAt(i));
		}
		
		// In mỗi từ trên một dòng
		String[] textArr = text.trim().split(" ");
		for(int i = 0; i < textArr.length; i++) {
			System.out.println(textArr[i]);
		}
		
		// In chuỗi đảo ngược theo kí tự
		StringBuilder reversedByChar = new StringBuilder(text);
		System.out.println("Chuỗi đảo ngược theo kí tự --> " 
				+ reversedByChar.reverse().toString());
		
		// In chuỗi đảo ngược theo từ
		StringBuilder reversedByWord = new StringBuilder();
		for(int i = textArr.length - 1; i >= 0; i--) {
			reversedByWord.append(textArr[i] + " ");
		}
		System.out.println("Chuỗi đảo ngược theo kí tự --> " 
				+ reversedByWord.toString().trim());
		
	}
	
}
