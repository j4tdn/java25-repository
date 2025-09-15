package view;
import java.util.Scanner;
public class Ex08PrimeNumber {
	public static void main(String[] args) {
		
        Scanner ip = new Scanner(System.in);
        int a = 5; 
        int N = 0;
        boolean i = false;

        
        while (a > 0) {
            System.out.print("Nhập số nguyên dương N: ");
            try {
                N = Integer.parseInt(ip.nextLine());

                if (N <= 0) {
                    throw new NumberFormatException(); 
                }

                
                if (isPrime(N)) {
                    i = true;
                    System.out.println("true");
                    break; 
                } else {
                    System.out.println("false");
                }

            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại");
            }

            a--; 
        }

        if (!i && a == 0) {
            System.out.println("Bạn đã nhập sai quá nhiều lần!");
        }
        ip.close();
}
        public static boolean isPrime(int num) {
            if (num < 2) {
                return false;
            }
            for (int N = 2; N <= Math.sqrt(num); N++) {
                if (num % N == 0) {
                    return false;
                }
            }
            return true;
    }
}
