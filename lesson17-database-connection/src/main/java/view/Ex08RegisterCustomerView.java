package view;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.Scanner;

import persistence.CustomerAccount;
import service.CustomerAccountService;
import service.CustomerAccountServiceImpl;
import utils.ConsoleInput;

public class Ex08RegisterCustomerView {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Câu 10 - Đăng ký tài khoản khách hàng");
            System.out.print("Nhập email: ");
            String email = scanner.nextLine();

            char[] password = ConsoleInput.readPassword(scanner, "Nhập mật khẩu (ít nhất 8 ký tự): ");
            char[] confirmation = ConsoleInput.readPassword(scanner, "Nhập lại mật khẩu: ");
            try {
                if (!Arrays.equals(password, confirmation)) {
                    System.out.println("Hai mật khẩu không khớp.");
                    return;
                }
                CustomerAccountService service = new CustomerAccountServiceImpl();
                CustomerAccount account = service.register(email, password);
                System.out.println("Tạo tài khoản thành công. Mã: " + account.id()
                        + ", Email: " + account.email());
                System.out.println("Chỉ lưu mật khẩu đã băm, không lưu mật khẩu gốc.");
            } finally {
                Arrays.fill(password, '\0');
                Arrays.fill(confirmation, '\0');
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("Email đã tồn tại trong hệ thống.");
        } catch (IllegalArgumentException | SQLException ex) {
            System.out.println("Đăng ký thất bại: " + ex.getMessage());
        }
    }
}
