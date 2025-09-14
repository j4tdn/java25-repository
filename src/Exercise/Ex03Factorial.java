package Exercise;

import java.util.Scanner;

public class Ex03Factorial {

    public static void main(String[] args) {

        /*
         * Bài 3: Viết chương trình tìm giai thừa của số nguyên dương N
         * - Nhập N từ bàn phím hoặc khai báo sẵn
         * Ví dụ:
         * N = 1 -> 1! = 1
         * N = 5 -> 5! = 5.4.3.2.1 = 120
         */

        Scanner scanner = new Scanner(System.in);

        // Đọc số nguyên dương N (tối đa 5 lần nhập sai)
        int n = readPositiveInt(scanner, 5);

        if (n == -1) {
            // Nếu trả về -1 nghĩa là nhập sai quá nhiều lần
            System.out.println("Bạn đã nhập sai quá nhiều lần. Chương trình dừng!");
        } else {
            // Tính giai thừa bằng vòng lặp
            long factorial = factorial(n);

            // In kết quả
            System.out.print(n + "! = ");
            for (int i = n; i >= 1; i--) {
                System.out.print(i);
                if (i > 1) {
                    System.out.print(" * ");
                }
            }
            System.out.println(" = " + factorial);
        }

        scanner.close();
    }

    // Hàm đọc số nguyên dương từ bàn phím
    private static int readPositiveInt(Scanner scanner, int maxTries) {
        int count = 0;

        while (count < maxTries) {
            System.out.print("Nhập số nguyên dương N: ");
            String input = scanner.nextLine().trim();

            try {
                int n = Integer.parseInt(input);
                if (n > 0) {
                    return n; // Nếu hợp lệ thì trả về kết quả.
                } else {
                    System.out.println("N phải là số nguyên dương! Hãy nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ! Hãy nhập lại.");
            }

            count++;
        }

        // Nếu nhập sai quá maxTries lần thì trả về -1
        return -1;
    }

    // Hàm tính giai thừa bằng vòng lặp
    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i; // nhân dồn kết quả
        }
        return result;
    }
}
