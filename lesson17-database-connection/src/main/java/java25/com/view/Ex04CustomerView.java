package java25.com.view;

import java25.com.service.CustomerService;
import java25.com.service.CustomerServiceImpl;

public class Ex04CustomerView {
    private static CustomerService customerService;

    static {
        customerService = new CustomerServiceImpl();
    }

    public static void main(String[] args) {

    }
}
