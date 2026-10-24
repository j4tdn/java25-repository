package java25.com.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.Objects;

public class PasswordUtils {
    private static final int COST_FACTOR = 12;

    private PasswordUtils() {
    }

    public static String hashPassword(String password) {
        Objects.requireNonNull(password, "Password is required");
        return BCrypt.withDefaults().hashToString(COST_FACTOR, password.toCharArray());
    }
}
