package view;

import static utils.StringUtils.*;

public class Ex07 {
	
	private static final int MAX_LENGTH = 255;

	public static void main(String[] args) {
		String text = null;
		try {
			text = inputString("Nhập vào 1 chuỗi: ", false);
			if(text.length() > MAX_LENGTH) {
				throw new IllegalArgumentException("Vượt quá max kí tự");
			}
			printMaxAndMinLength(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printMaxAndMinLength(String s) {
        if (s == null || s.isEmpty()) {
            return;
        }

        int maxLength = 1, minLength = 255;
        int maxStartIndex = 0, minStartIndex = 0;
        int currentLength = 1, startIndex = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStartIndex = startIndex;
                }
                if (currentLength < minLength) {
                    minLength = currentLength;
                    minStartIndex = startIndex;
                }
                currentLength = 1;
                startIndex = i;
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxStartIndex = startIndex;
        }
        if (currentLength < minLength) {
            minLength = currentLength;
            minStartIndex = startIndex;
        }

        String maxSubstring = s.substring(maxStartIndex, maxStartIndex + maxLength);
        String minSubstring = s.substring(minStartIndex, minStartIndex + minLength);

        System.out.println("Độ dài lớn nhất của dãy con đúng: " + maxLength 
            + " \"" + maxSubstring + "\" [" + maxStartIndex + "]");
        System.out.println("Độ dài nhỏ nhất của dãy con đúng: " + minLength 
            + " \"" + minSubstring + "\" [" + minStartIndex + "]");
    }
	
}
