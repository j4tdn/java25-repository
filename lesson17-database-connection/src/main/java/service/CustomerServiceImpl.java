package service;

import dao.CustomerDao;
import dao.JdbcCustomerDao;
import persistence.Customer;
import utils.PasswordUtils;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    public CustomerServiceImpl() {
        customerDao = new JdbcCustomerDao();
    }

    @Override
    public boolean register(String name, String email, String password) {
        if (name == null || name.isBlank()
                || email == null || email.isBlank()
                || password == null || password.isBlank()) {
            return false;
        }

        if (customerDao.getByEmail(email) != null) {
            System.out.println("Email da ton tai.");
            return false;
        }

        Customer customer = new Customer(null, name.trim(), email.trim(),
                password);
        return customerDao.add(customer);
    }

    @Override
    public Customer login(String email, String password) {
        if (email == null || email.isBlank()
                || password == null || password.isBlank()) {
            return null;
        }

        Customer customer = customerDao.getByEmail(email.trim());

        if (customer != null
                && PasswordUtils.verifyPassword(password, customer.getPassword())) {
            return new Customer(customer.getId(), customer.getName(),
                    customer.getEmail(), null);
        }

        return null;
    }
}
