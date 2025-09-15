package hoten.lesson02;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int N = -1;

        while (attempts < 5) {
            System.out.print("Nhập số nguyên dương N: ");
            String input = scanner.nextLine();
            if (isValidPositiveInteger(input)) {
                N = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập số nguyên dương.");
                attempts++;
            }
        }

        if (N > 0) {
            if (isPowerOfTwo(N)) {
                System.out.println(N + " là lũy thừa của 2 ✅");
            } else {
                System.out.println(N + " không phải là lũy thừa của 2 ❌");
            }
        } else {
            System.out.println("Đã vượt quá số lần nhập. Chương trình kết thúc.");
        }

        scanner.close();
    }
    public static boolean isValidPositiveInteger(String str) {
        if (str == null || str.isEmpty()) return false;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return Integer.parseInt(str) > 0;
    }
    
    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
}