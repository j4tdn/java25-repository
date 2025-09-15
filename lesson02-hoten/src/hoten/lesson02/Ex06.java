package hoten.lesson02;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = getValidInt(scanner, "a");
        int b = getValidInt(scanner, "b");
        int c = getValidInt(scanner, "c");

        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));

        System.out.println("Số lớn nhất là: " + max);
        System.out.println("Số nhỏ nhất là: " + min);

        scanner.close();
    }

    public static int getValidInt(Scanner scanner, String name) {
        int value;
        while (true) {
            System.out.print("Nhập " + name + " (0–19): ");
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                value = Integer.parseInt(input);
                if (value >= 0 && value < 20) break;
            }
            System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại.");
        }
        return value;
    }
}