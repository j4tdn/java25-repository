package exercise;

import java.util.Scanner;

public class Ex02CheckPassword {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        final int MAX = 5;

        while (count < MAX) {
            System.out.print("Nhập mật khẩu: ");
            String pw = sc.nextLine();

            try {
                validatePassword(pw);
                System.out.println("Đăng ký tài khoản thành công");
                return;

            } catch (Ex02PasswordInvalidException e) {
                count++;
                System.out.println(e.getMessage());
                System.out.println("Bạn còn " + (MAX - count) + " lần thử\n");
            }
        }

        System.out.println("Bạn đã nhập sai quá 5 lần, Tài khoản bị khóa.");
    }

    public static void validatePassword(String pw) throws Ex02PasswordInvalidException {

        if (pw.length() < 8)
            throw new Ex02PasswordInvalidException("Mật khẩu phải có ít nhất 8 ký tự");

        if (pw.length() > 256)
            throw new Ex02PasswordInvalidException("Mật khẩu phải nhỏ hơn 256 ký tự");

        if (!pw.matches(".*[a-z].*"))
            throw new Ex02PasswordInvalidException("Mật khẩu phải chứa ít nhất 1 chữ thường");

        if (!pw.matches(".*[A-Z].*"))
            throw new Ex02PasswordInvalidException("Mật khẩu phải chứa ít nhất 1 chữ hoa");

        if (!pw.matches(".*[0-9].*"))
            throw new Ex02PasswordInvalidException("Mật khẩu phải chứa ít nhất 1 chữ số");

        if (!pw.matches(".*[!@#$%^&*()\\-_=+{}\\[\\]:;\"'<>,.?/].*"))
            throw new Ex02PasswordInvalidException("Mật khẩu phải chứa ít nhất 1 ký tự đặc biệt");
    }
}
