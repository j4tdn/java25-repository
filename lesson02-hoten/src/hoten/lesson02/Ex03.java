package hoten.lesson02;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;

        System.out.print("Nhập số nguyên dương N: ");
        N = scanner.nextInt();

        if (N <= 0) {
            System.out.println("N phải là số nguyên dương.");
        } else {
            long factorial = 1;
            for (int i = 1; i <= N; i++) {
                factorial *= i;
            }
            System.out.println(N + "! = " + factorial);
        }

        scanner.close();
    }
}

