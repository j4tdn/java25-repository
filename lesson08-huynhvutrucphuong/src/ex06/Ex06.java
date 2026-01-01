package ex06;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        long K = sc.nextLong();

        long len = 1, count = 9, start = 1;

        while (K > len * count) {
            K -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        long number = start + (K - 1) / len;
        int index = (int) ((K - 1) % len);

        System.out.println(String.valueOf(number).charAt(index));
	}
}
