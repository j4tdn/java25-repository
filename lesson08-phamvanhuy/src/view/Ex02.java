package view;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập họ tên: ");
        String s = sc.nextLine().trim();

        String[] arr = s.split(" ");
        String result = "";

        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (!word.isEmpty()) {

                char first = word.charAt(0);
                if (first >= 'a' && first <= 'z') {
                    first = (char) (first - 32);
                }
                result += first;

                for (int j = 1; j < word.length(); j++) {
                    char c = word.charAt(j);
                    if (c >= 'A' && c <= 'Z') {
                        c = (char) (c + 32);
                    }
                    result += c;
                }

                result += " ";
            }
        }

        System.out.println(result.trim());
    }
}


