package view;

import java.util.Scanner;

import persistence.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

public class Ex06LoginView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService service = new CustomerServiceImpl();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Customer customer = service.login(email, password);

        if (customer != null) {
            System.out.println("Dang nhap thanh cong.");
            System.out.println("Xin chao " + customer.getName());
        } else {
            System.out.println("Email hoac mat khau khong dung.");
        }
    }
}
