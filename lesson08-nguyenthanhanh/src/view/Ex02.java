package view;

import static utils.StringUtils.*;

public class Ex02 {

	public static void main(String[] args) {
		
		String text = null;
		try {
			text = inputString("Nhập vào 1 chuỗi: ", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		StringBuilder sb = new StringBuilder();
		String[] textArr = text.trim().split(" ");
		for(int i = 0; i < textArr.length; i++) {
			String word = textArr[i];
			StringBuilder formattedWord = new StringBuilder();
			String lowerWord = word.toLowerCase();
			formattedWord.append(lowerWord.substring(0, 1).toUpperCase() 
					+ lowerWord.substring(1));
			sb.append(formattedWord + " ");
		}
		
		System.out.println("Sau khi format --> " + sb.toString().trim());
		
	}
	
}
