package view;
import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();

        int count = 1;
        int start = 0;

        int maxLen = 1, minLen = Integer.MAX_VALUE; // length, position
        int maxPos = 0, minPos = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                if (count > maxLen) {
                    maxLen = count;
                    maxPos = start;
                }
                if (count < minLen) {
                    minLen = count;
                    minPos = start;
                }
                count = 1;
                start = i;
            }
        }

        // xử lý dãy cuối
        if (count > maxLen) {
            maxLen = count;
            maxPos = start;
        }
        if (count < minLen) {
            minLen = count;
            minPos = start;
        }

        String maxStr = s.substring(maxPos, maxPos + maxLen);
        String minStr = s.substring(minPos, minPos + minLen);

        System.out.println("Độ dài lớn nhất của dãy con đúng : "
                + maxLen + " " + maxStr + " [" + maxPos + "]");
        System.out.println("Độ dài nhỏ nhất của dãy con đúng: "
                + minLen + " " + minStr + " [" + minPos + "]");
    }
}
