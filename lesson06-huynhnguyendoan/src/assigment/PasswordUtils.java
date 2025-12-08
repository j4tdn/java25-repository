package assigment;

public class PasswordUtils {
	public static void validatePassword(String password) throws PasswordException {
        if (password.length() < 8) {
            throw new PasswordException("Mat khau phai co it nhat 8 ky tu");
        }
        if (password.length() > 256) {
            throw new PasswordException("Mat khau khong duoc vuot qua 256 ky tu");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new PasswordException("Mat khau phai co it nhat 1 chu thuong");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new PasswordException("Mat khau phai co it nhat 1 chu hoa");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new PasswordException("Mat khau phai co it nhat 1 chu so");
        }
        if (!password.matches(".*[~!@#$%^&*()_\\-+=\\[\\]{}|;:,.<>/?].*")) {
            throw new PasswordException("Mat khau phai co it nhat 1 ky tu dac biet");
        }
    }
}
