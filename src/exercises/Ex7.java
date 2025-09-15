package exercises;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số tự nhiên N: ");
        int N = sc.nextInt();

        if (N == 0) {
            System.out.println("Số nhị phân: 0");
            return;
        }

        String binary = ""; 

        while (N > 0) {
            int du = N % 2;         
            binary = du + binary;   
            N = N / 2;             
        }


        System.out.println("Số nhị phân: " + binary);
    }
}
