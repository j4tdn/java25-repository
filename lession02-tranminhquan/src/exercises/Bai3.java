package exercises;

import java.util.Scanner;

public class Bai3 {

    public static void main(String[] args) {
        Bai3.run();
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        int N;
        long result = 1;

        System.out.print("Nhập số nguyên dương N: ");

        if (sc.hasNextInt()) {
            N = sc.nextInt();
            if (N > 0) {
                for (int i = 1; i <= N; i++) {
                    result *= i;
                }
                System.out.println(N + "! = " + result);
            } else {
                System.out.println("N phải > 0!");
            }
        } else {
            System.out.println("Nhập sai định dạng, cần số nguyên!");
        }
    }
}
