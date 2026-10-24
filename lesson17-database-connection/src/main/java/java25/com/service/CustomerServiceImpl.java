package java25.com.service;

import java25.com.dao.CustomerDao;
import java25.com.dao.JdbcCustomerDao;
import java25.com.persistence.Customer;

import java.util.Objects;

public class CustomerServiceImpl implements CustomerService{
    private final CustomerDao customerDao;

    public CustomerServiceImpl() {
        customerDao = new JdbcCustomerDao();
    }

    @Override
    public boolean createAccount(Customer request) {
        Objects.requireNonNull(request, "Customer data is required");
        return customerDao.createAccount(request);
    }
}
