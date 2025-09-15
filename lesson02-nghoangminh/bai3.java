package nghoangminh_lesson02exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class bai3 {

	public static void main(String[] args) {
	  
	    Scanner scanner = new Scanner(System.in);

        // Nhập số N
        System.out.print("Nhập số nguyên dương N: ");
        int N = scanner.nextInt();

        if (N < 0) {
            System.out.println("N phải là số nguyên dương!");
        } else {
            BigInteger factorial = BigInteger.ONE;

            // In theo định dạng: N! = N . (N-1) . ... . 1
            System.out.print(N + "! = ");
            for (int i = N; i >= 1; i--) {
            	factorial = factorial.multiply(BigInteger.valueOf(i));
                System.out.print(i);
                if (i > 1) {
                    System.out.print(" x "); // dấu chấm giữa các số
                }
            }
            System.out.println(" = " + factorial);
        }

        scanner.close();
    }
}
