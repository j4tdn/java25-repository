import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().trim();
        String s2 = sc.nextLine().trim();

        System.out.println(longestCommonSubstring(s1, s2));
    }

    private static String longestCommonSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        int bestLen = 0;
        int endPos = 0;

        for (int i = 1; i <= m; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                if (c1 == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > bestLen) {
                        bestLen = dp[i][j];
                        endPos = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return s1.substring(endPos - bestLen, endPos);
    }
}
