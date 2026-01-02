package exercise;

public class Bai7 {
    public static void main(String[] args) {
        String s = "aaabaaabbaaaaa";

        int max = 1, min = Integer.MAX_VALUE;
        int count = 1, start = 0;
        int maxPos = 0, minPos = 0;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                if (count > max) { max = count; maxPos = start; }
                if (count < min) { min = count; minPos = start; }
                count = 1;
                start = i;
            }
        }

        System.out.println("Max = " + max + " tại [" + maxPos + "]");
        System.out.println("Min = " + min + " tại [" + minPos + "]");
    }
}

