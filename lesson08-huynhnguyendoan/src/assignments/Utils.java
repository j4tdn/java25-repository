package assignments;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Utils {
    public static String normalizeFullName(String name) {

        if (!name.matches("[A-Za-z ]+")) {
            return null;
        }

        name = name.trim().replaceAll("\\s+", " ");

        String[] words = name.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String normalizedWord =
                    word.substring(0, 1).toUpperCase()
                  + word.substring(1).toLowerCase();

            result.append(normalizedWord).append(" ");
        }

        return result.toString().trim();
    }
    public static String removeAccent(String input) {

        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);

        String withoutAccent = Pattern.compile("\\p{InCombiningDiacriticalMarks}+").matcher(normalized).replaceAll("");

        withoutAccent = withoutAccent.replace("đ", "d").replace("Đ", "D");

        return withoutAccent;
    }
        public static String longestCommonSubstring(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();

            int[][] dp = new int[m + 1][n + 1];

            int maxLen = 0;
            int endIndex = 0;

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;

                        if (dp[i][j] > maxLen) {
                            maxLen = dp[i][j];
                            endIndex = i;
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }

            return s1.substring(endIndex - maxLen, endIndex);
        }

}

