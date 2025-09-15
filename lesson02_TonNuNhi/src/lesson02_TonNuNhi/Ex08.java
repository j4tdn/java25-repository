package lesson02_TonNuNhi;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {

        Scanner ip = new Scanner(System.in);
        String text;
        int count = 0;
        int n = 0;
        boolean ok = false;

        do {
            System.out.print("Nhập số nguyên dương N: ");
            text = ip.nextLine();

            if (isValidText(text)) {
                n = Integer.parseInt(text);
                if (n > 0) {
                    ok = true;
                    break;
                }
            }

            System.out.println("Chưa phải là số hợp lệ \n");

            count = count + 1;
            if (count == 5) {
                System.out.println("Đã quá số lần nhập");
                ip.close();
                return;
            }
        } while (true);

        if (ok) {
            boolean result = isPrime(n);
            System.out.println(result);
        }

        ip.close();
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        int i = 3;
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            i = i + 2;
        }
        return true;
    }

    private static boolean isValidText(String text) {
        if (text == null) return false;
        if (text.length() == 0) return false;
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
