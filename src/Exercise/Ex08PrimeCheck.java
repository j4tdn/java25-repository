package Exercise;

import java.util.Scanner;

public class Ex08PrimeCheck {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = readPositiveInt(scanner, 5);

        if (n == -1) {
            // Nếu nhập sai quá số lần cho phép thì kết thúc chương trình
            System.out.println("Bạn đã nhập sai quá số lần cho phép. Kết thúc chương trình!");
            return;
        }

        // Kiểm tra N có phải số nguyên tố hay không
        if (isPrime(n)) {
            System.out.println(n + " là số nguyên tố.");
        } else {
            System.out.println(n + " không phải là số nguyên tố.");
        }
    }


     // Hàm đọc số nguyên dương từ bàn phím:
 
    public static int readPositiveInt(Scanner scanner, int maxAttempts) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            System.out.print("Lần nhập " + (attempts + 1) + " - Nhập số nguyên dương N: ");
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input); // chuyển từ chuỗi sang số nguyên.
                if (value > 0) {
                    return value; 
                } else {
                    System.out.println(" Sai! N phải là số nguyên dương.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Sai định dạng! Vui lòng nhập số nguyên.");
            }

            attempts++;
        }
        return -1;}
    


     // Hàm kiểm tra số nguyên tố:
    
    public static boolean isPrime(int n) {
    	
        if (n < 2) return false;       // số nhỏ hơn 2 không phải số nguyên tố
        if (n == 2) return true;       // 2 là số nguyên tố
        if (n % 2 == 0) return false;  // số chẵn lớn hơn 2 thì không phải số nguyên tố

        // chỉ cần kiểm tra  căn bậc hai của n:
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false; // chia hết cho i → không phải nguyên tố
            }
        }
        return true;
    }
}
