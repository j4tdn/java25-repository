package exercise;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();

      
        System.out.println("Mỗi ký tự:");
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }

      
        System.out.println("Mỗi từ:");
        String[] words = s.trim().split("\\s+");
        for (String w : words) {
            System.out.println(w);
        }

       
        StringBuilder revChar = new StringBuilder(s).reverse();
        System.out.println("Đảo theo ký tự: " + revChar);


        StringBuilder revWord = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            revWord.append(words[i]).append(" ");
        }
        System.out.println("Đảo theo từ: " + revWord.toString().trim());
    }
}

