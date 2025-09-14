package Exercise;
import java.util.Scanner;

public class Ex05Palindrome {

	public static void main(String[] args) {

        /*
         * Bài 5: Kiểm tra số nguyên dương N có phải là số đối xứng hay không
         * - N nhập từ bàn phím, phải là số nguyên dương có ít nhất 2 chữ số
         * - Nếu nhập sai (abc, ký tự lẫn số, số < 10) → báo lỗi và nhập lại
         * Ví dụ:
         * N = 256   → false
         * N = 12521 → true
         * N = 2662  → true
         */

        Scanner scanner = new Scanner(System.in);

        int n = readValidInt(scanner, 5);

        if (n == -1) {
            System.out.println("Bạn đã nhập sai quá nhiều lần. Chương trình dừng!");
        } else {
            boolean result = isPalindrome(n);
            System.out.println(n + " có phải là số đối xứng không? " + result);
        }

        scanner.close(); // đóng việc nhập dữ liệu lại, tránh lỗi IllegalStateException.
    }

    // Hàm đọc số nguyên dương >= 10 (tối thiểu 2 chữ số)
    private static int readValidInt(Scanner scanner, int maxTries) {
        int count = 0;

        while (count < maxTries) {
            System.out.print("Nhập số nguyên dương N (>= 10): ");
            String input = scanner.nextLine().trim();

            try {
                int n = Integer.parseInt(input);
                if (n >= 10) {
                    return n; // hợp lệ
                } else {
                    System.out.println("N phải có ít nhất 2 chữ số (>= 10). Hãy nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ! Hãy nhập lại.");
            }

            count++;
        }

        return -1; // nhập sai quá nhiều lần
    }

    // Hàm kiểm tra số đối xứng: 
    private static boolean isPalindrome(int n) {
        String original = String.valueOf(n); // chuyển số thành chuỗi
        String reversed = new StringBuilder(original).reverse().toString(); // đảo ngược chuỗi
        return original.equals(reversed); // so sánh 2 chuỗi với equal ( so sánh nội dung chứ không phải đối tượng được trỏ đến nếu dùng ==)
    }
}
