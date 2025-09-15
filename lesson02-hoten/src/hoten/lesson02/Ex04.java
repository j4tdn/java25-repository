package hoten.lesson02;

import java.util.Random;

public class Ex04 {
    public static void main(String[] args) {
        Random rd = new Random(); 

        int a = rd.nextInt(11) + 10;
        int b = rd.nextInt(11) + 10;
        int c = rd.nextInt(11) + 10;
        int d = rd.nextInt(11) + 10;

        long sum = factorial(a) + factorial(b) + factorial(c) + factorial(d);

        System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
        System.out.println("Tổng giai thừa S = a! + b! + c! + d! = " + sum);
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }
}