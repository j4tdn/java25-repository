package Exercise;
import java.util.Scanner;


public class Ex06MinMax {

	 public static void main(String[] args) {

	        /*
	         * Bài 6: Tìm số nguyên lớn nhất và nhỏ nhất trong 3 số a, b, c đc nhập vào.
	         * - Các số được nhập từ bàn phím
	         * - Điều kiện: 0 <= a, b, c < 20
	         * - Nếu nhập sai kiểu (vd: "xyz") hoặc ngoài khoảng → báo lỗi, nhập lại
	         * - Giới hạn nhập sai: 5 lần
	         * Ví dụ:
	         * a = 6
	         * b = 12
	         * c = 8
	         * → Số lớn nhất là 12, nhỏ nhất là 6
	         */
		 Scanner scanner = new Scanner(System.in);

	        // Nhập 3 số a, b, c với prompt tự đánh số lần nhập 1, 2, 3
	        int a = readIntInRange(scanner, 5, 0, 20, 1); // gọi hàm với scanner nhập dữ liệu từ bàn phím, số lần nhập tối đa, giá trị hợp lệ 
	        																		// nhỏ nhất, giá trị hợp lệ lớn nhất, lần nhập.
	        if (a == -1) return;

	        int b = readIntInRange(scanner, 5, 0, 20, 2);
	        if (b == -1) return;

	        int c = readIntInRange(scanner, 5, 0, 20, 3);
	        if (c == -1) return;

	        int max = Math.max(a, Math.max(b, c));
	        int min = Math.min(a, Math.min(b, c));

	        System.out.println("Số lớn nhất là: " + max);
	        System.out.println("Số nhỏ nhất là: " + min);

	        scanner.close();
	    }

	    // Hàm nhập số nguyên [min, max) 
	    private static int readIntInRange(Scanner scanner, int maxTries, int min, int max, int order) {
	        int count = 0;

	        while (count < maxTries) {
	            System.out.print("Nhập số nguyên lần thứ " + order + " trong khoảng [" + min + ", " + (max - 1) + "]: ");
	            String input = scanner.nextLine().trim();

	            try {
	                int n = Integer.parseInt(input);
	                if (n >= min && n < max) {
	                    return n; // hợp lệ
	                } else {
	                    System.out.println("Số phải nằm trong khoảng [" + min + ", " + (max - 1) + "]! Hãy nhập lại.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Dữ liệu không hợp lệ! Hãy nhập lại.");
	            }

	            count++;
	        }

	        System.out.println("Bạn đã nhập sai quá nhiều lần. Chương trình dừng!");
	        return -1;
	    }
	}

