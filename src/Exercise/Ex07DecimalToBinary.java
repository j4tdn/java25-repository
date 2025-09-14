package Exercise;
import java.util.Scanner;

public class Ex07DecimalToBinary {

	 public static void main(String[] args) {
	        /*
	         * Bài 7: Chuyển đổi số tự nhiên ở hệ cơ số 10 sang hệ cơ số 2
	         * - Nhập số N từ bàn phím (N >= 0)
	         * Ví dụ:
	         * N = 0  → "0"
	         * N = 1  → "1"
	         * N = 2  → "10"
	         * N = 3  → "11"
	         * N = 4  → "100"
	         * N = 5  → "101"
	         */

	        Scanner scanner = new Scanner(System.in);

	        int n = readNonNegativeInt(scanner, 5); // make sure là k có số âm.

	        if (n == -1) {
	            System.out.println("Bạn đã nhập sai quá nhiều lần. Chương trình dừng!");
	        } else {
	            String binary = decimalToBinary(n);
	            System.out.println("Số " + n + " ở hệ nhị phân là: " + binary);
	        }

	        scanner.close();
	    }

	    // Hàm đọc số nguyên >= 0
	    private static int readNonNegativeInt(Scanner scanner, int maxTries) {
	        int count = 0;
	        while (count < maxTries) {
	            System.out.print("Nhập số tự nhiên N (>= 0): ");
	            String input = scanner.nextLine().trim();
	            try {
	                int n = Integer.parseInt(input);
	                if (n >= 0) {
	                    return n;
	                } else {
	                    System.out.println("N phải là số >= 0! Hãy nhập lại.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Dữ liệu không hợp lệ! Hãy nhập lại.");
	            }
	            count++;
	        }
	        return -1;
	    }

	    // Hàm chuyển đổi thập phân sang nhị phân
	    private static String decimalToBinary(int n) {
	        if (n == 0) return "0"; // trường hợp đặc biệt

	        StringBuilder binary = new StringBuilder();
	        while (n > 0) {
	            int remainder = n % 2;      // lấy số dư khi chia 2
	            binary.append(remainder);   // thêm số dư vào chuỗi
	            n = n / 2;                  // giảm n đi 1 bậc
	        }
	        return binary.reverse().toString(); // đảo ngược chuỗi để ra kết quả đúng
	    }
}
