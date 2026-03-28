package utils;

public class NumberUtils {
	public static boolean isHappy(int n) {
		for (int i = 0; i < 100; i++) {

            int sum = 0;

            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;

            if (n == 1) {
                return true;
            }
        }

        return false;
    }
}
