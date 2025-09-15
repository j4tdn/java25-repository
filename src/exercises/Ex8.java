package exercises;

public class Ex8 {
    public static void main(String[] args) {
        int N = 7;

        boolean result = isPrime(N);

        System.out.println("N = " + N + " -> " + result);
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;   
        if (n == 2) return true;    
        if (n % 2 == 0) return false; 

        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false; 
            }
        }
        return true; 
    }
}
