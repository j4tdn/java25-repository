package view;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap sau S: ");
        String s = sc.nextLine();

        int n = s.length();
        int maxLen = 0, minLen = n + 1;
        int maxPos = 0, minPos = 0;
        
        int i = 0;
        while (i < n) {
            int start = i;
            char currentChar = s.charAt(i);
            
            while (i < n && s.charAt(i) == currentChar) {
                i++;
            }
            
            int currentLen = i - start;

            if (currentLen > maxLen) {
                maxLen = currentLen;
                maxPos = start;
            }

            if (currentLen < minLen) {
                minLen = currentLen;
                minPos = start;
            }
        }

        System.out.println("Do dai lon nhat day: " + maxLen + " \"" + s.substring(maxPos, maxPos + maxLen) + "\" [" + maxPos + "]");
        System.out.println("Do dai nho nhat day: " + minLen + " \"" + s.substring(minPos, minPos + minLen) + "\" [" + minPos + "]");
        
        sc.close();
	}
	
}
