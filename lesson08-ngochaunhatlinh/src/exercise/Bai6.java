package exercise;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();

        long len = 1, count = 9, start = 1;
        while (k > len * count) {
            k -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        long num = start + (k - 1) / len;
        int index = (int)((k - 1) % len);

        System.out.println(String.valueOf(num).charAt(index));
    }
}

