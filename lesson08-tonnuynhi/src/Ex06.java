import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        System.out.println(digitAt(k));
    }

    private static int digitAt(long k) {
        long d = 1;
        long start = 1;

        while (true) {
            long count = 9 * start;
            long blockDigits = count * d;
            if (k > blockDigits) {
                k -= blockDigits;
                d++;
                start *= 10;
            } else {
                break;
            }
        }

        long index = k - 1;
        long number = start + index / d;
        int pos = (int)(index % d);

        String s = Long.toString(number);
        return s.charAt(pos) - '0';
    }
}
