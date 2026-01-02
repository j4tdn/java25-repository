import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        long g = gcd(n, m);
        boolean ok = reduceToOne(n, g) && reduceToOne(m, g);

        System.out.println(ok ? "YES" : "NO");
    }

    private static boolean reduceToOne(long a, long g) {
        long x = a;
        while (true) {
            long t = gcd(x, g);
            if (t == 1) break;
            while (x % t == 0) x /= t;
        }
        return x == 1;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a < 0 ? -a : a;
    }
}
