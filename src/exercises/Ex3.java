package exercises;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương N: ");
        int N = sc.nextInt(); 

        if (N < 0) {
            System.out.println("N không phải là số nguyên dương!");
            return; 
        }

        long temp = 1; 
        for (int i = 1; i <= N; i++) {
            temp *= i; 
        }

        System.out.println(N + "! = " + temp);
    }
}
