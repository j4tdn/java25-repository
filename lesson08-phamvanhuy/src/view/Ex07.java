package view;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập xâu S: ");
        String s = sc.nextLine();

        int max = 1;
        int min = s.length();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                if (count < min) {
                    min = count;
                }
                count = 1;
            }
        }

        if (count > max) max = count;
        if (count < min) min = count;

        System.out.println("Độ dài lớn nhất: " + max);
        System.out.println("Độ dài nhỏ nhất: " + min);
    }
}

