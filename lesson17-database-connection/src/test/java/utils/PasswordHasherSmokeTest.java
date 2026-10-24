package utils;

import java.util.Arrays;

public class PasswordHasherSmokeTest {

    public static void main(String[] args) {
        char[] password = "PracticeJava2026!".toCharArray();
        char[] wrongPassword = "WrongPassword2026!".toCharArray();
        try {
            String first = PasswordHasher.hash(password);
            String second = PasswordHasher.hash(password);
            if (first.equals(second)) {
                throw new AssertionError("Different salts must create different hashes.");
            }
            if (!PasswordHasher.verify(password, first)
                    || !PasswordHasher.verify(password, second)
                    || PasswordHasher.verify(wrongPassword, first)) {
                throw new AssertionError("Password hash verification failed.");
            }
            System.out.println("PasswordHasher OK");
        } finally {
            Arrays.fill(password, '\0');
            Arrays.fill(wrongPassword, '\0');
        }
    }
}
