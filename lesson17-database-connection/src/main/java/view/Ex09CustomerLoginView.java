package view;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import persistence.CustomerAccount;
import service.CustomerAccountService;
import service.CustomerAccountServiceImpl;
import utils.ConsoleInput;

public class Ex09CustomerLoginView {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Câu 11 - Đăng nhập tài khoản khách hàng");
            System.out.print("Nhập email: ");
            String email = scanner.nextLine();

            char[] password = ConsoleInput.readPassword(scanner, "Nhập mật khẩu: ");
            try {
                CustomerAccountService service = new CustomerAccountServiceImpl();
                Optional<CustomerAccount> account = service.login(email, password);
                if (account.isPresent()) {
                    System.out.println("Đăng nhập thành công. Xin chào " + account.get().email());
                } else {
                    System.out.println("Email hoặc mật khẩu không đúng.");
                }
            } finally {
                Arrays.fill(password, '\0');
            }
        } catch (IllegalArgumentException | SQLException ex) {
            System.out.println("Không thể đăng nhập: " + ex.getMessage());
        }
    }
}
