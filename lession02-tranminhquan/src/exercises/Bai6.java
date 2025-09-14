package exercises;

import java.util.Scanner;

public class Bai6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = nhapSo(sc, "a");
        int b = nhapSo(sc, "b");
        int c = nhapSo(sc, "c");

        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;

        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;

        System.out.println("Số lớn nhất là " + max);
        System.out.println("Số nhỏ nhất là " + min);
    }

    public static int nhapSo(Scanner sc, String ten) {
        while (true) {
            System.out.print("Nhập số " + ten + ": ");

            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (n >= 0 && n <= 20) {
                    return n;
                } else {
                    System.out.println("Số phải từ 0-20.");
                }
            } else {
                System.out.println("Phải nhập số nguyên.");
                sc.next();
            }
        }
    }
}
