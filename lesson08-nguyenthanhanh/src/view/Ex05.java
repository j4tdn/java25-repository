package view;

import static utils.StringUtils.*;

public class Ex05 {
	
	public static void main(String[] args) {
		String s1,s2 = null;
		try {
			s1 = inputString("Nhập vào 1 chuỗi: ", false);
			s2 = inputString("Nhập vào 1 chuỗi: ", false);
			System.out.println("Xâu con chung dài nhất của xâu " + s1 + " và " + s2 + 
					" --> " + findLongestCommonSubstring(s1,s2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String findLongestCommonSubstring(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return "";
        }

        if (s1.equals(s2)) {
            return s1;
        }

        int m = s1.length();
        int n = s2.length();

        int lengthOfMaxCommonnSubString = 0;
        int endIndex = 0;

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;

                    if (curr[j] > lengthOfMaxCommonnSubString) {
                    	lengthOfMaxCommonnSubString = curr[j];
                        endIndex = i;
                    }
                } else {
                    curr[j] = 0;
                }
            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        if (lengthOfMaxCommonnSubString == 0) {
            return "";
        }

        return s1.substring(endIndex - lengthOfMaxCommonnSubString, endIndex);
    }
	
}
