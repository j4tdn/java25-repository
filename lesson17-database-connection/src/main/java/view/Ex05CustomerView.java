package view;

import java.util.Scanner;
import service.CustomerService;
import service.CustomerServiceImpl;

public class Ex05CustomerView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService service = new CustomerServiceImpl();

        System.out.print("Nhap ten khach hang: ");
        String name = scanner.nextLine();

        System.out.print("Nhap email: ");
        String email = scanner.nextLine();

        System.out.print("Nhap mat khau: ");
        String password = scanner.nextLine();

        boolean result = service.register(name, email, password);

        if (result) {
            System.out.println("Tao tai khoan thanh cong.");
        } else {
            System.out.println("Tao tai khoan that bai.");
        }
    }
}
