package leeson03;

import java.util.Scanner;

public class Pascal {
	public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Nhập N(số hàng tam giác): ");
        int n = ip.nextInt();

        for (int i = 0; i < n; i++) {
            for (int s = 0; s < n - 1; s++) {
                System.out.print(" ");
            }

            int number = 1; 
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }

            System.out.println();
        }
        ip.close();
    }

}
