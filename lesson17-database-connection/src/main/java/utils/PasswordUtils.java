package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {

    private PasswordUtils() {
    }

    public static String hashPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password khong duoc null");
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));

            StringBuilder result = new StringBuilder();
            for (byte b : hash) {
                result.append(String.format("%02x", b));
            }

            return result.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Khong ho tro SHA-256", e);
        }
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        if (password == null || hashedPassword == null) {
            return false;
        }

        return hashPassword(password).equalsIgnoreCase(hashedPassword);
    }
}
