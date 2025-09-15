package exercises;

public class Ex9 {
    public static void main(String[] args) {
        int target = 200;    
        int count = 0;       
        int n = 1;           

        while (count < target) {
            n++;

            boolean isPrime = true;

            if (n <= 1) {
                isPrime = false;
            } else if (n == 2) {
                isPrime = true; 
            } else if (n % 2 == 0) {
                isPrime = false; 
            } else {
                int sqrt = (int) Math.sqrt(n); 
                for (int i = 3; i <= sqrt; i += 2) {
                    if (n % i == 0) {
                        isPrime = false;
                        break; 
                    }
                }
            }

            if (isPrime) {
                count++;
            }
        }

        System.out.println("Số nguyên tố thứ 200 là: " + n); 
    }
}
