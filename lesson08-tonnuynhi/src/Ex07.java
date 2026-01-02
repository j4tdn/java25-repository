
import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();

        Result r = analyzeRuns(s);

        System.out.println(r.maxLen + " " + r.maxStart);
        System.out.println(r.minLen + " " + r.minStart);
    }

    private static Result analyzeRuns(String s) {
        int n = s.length();

        int maxLen = 1, maxStart = 0;
        int minLen = Integer.MAX_VALUE, minStart = 0;

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            int len = j - i;

            if (len > maxLen) {
                maxLen = len;
                maxStart = i;
            }

            if (len < minLen) {
                minLen = len;
                minStart = i;
            }

            i = j;
        }

        return new Result(maxLen, maxStart, minLen, minStart);
    }

    private static class Result {
        int maxLen, maxStart, minLen, minStart;

        Result(int maxLen, int maxStart, int minLen, int minStart) {
            this.maxLen = maxLen;
            this.maxStart = maxStart;
            this.minLen = minLen;
            this.minStart = minStart;
        }
    }
}
