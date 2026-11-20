package service;

import java.util.Objects;

import dao.CustomerDao;
import dao.JdbcCustomerDao;
import persistence.Customer;

public class CustomerServiceImpl implements CustomerService {

	private final CustomerDao customerDao;

	public CustomerServiceImpl() {
		this.customerDao = new JdbcCustomerDao();
	}

	@Override
	public void save(Customer customer) {
		Objects.requireNonNull(customer, "customer must not be null");
		customerDao.save(customer);
	}
	
	@Override
	public Customer login(String email, String password) {
		Objects.requireNonNull(email, "email must not be null");
		Objects.requireNonNull(password, "password must not be null");
		return customerDao.login(email, password);
	}

}
