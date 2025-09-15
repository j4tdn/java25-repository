package exercises;


import java.util.Random;

public class Ex4 {
	
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Random rand = new Random();

        int a = rand.nextInt(11) + 10; 
        int b = rand.nextInt(11) + 10;
        int c = rand.nextInt(11) + 10;
        int d = rand.nextInt(11) + 10;

        long sum = factorial(a) + factorial(b) + factorial(c) + factorial(d);

        System.out.println("Các số ngẫu nhiên: a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
        System.out.println("S = " + a + "! + " + b + "! + " + c + "! + " + d + "! = " + sum);
    }
}
