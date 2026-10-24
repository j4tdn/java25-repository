package service;

import java.util.Objects;

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
	public Customer createAccount(Customer customer, String rawPassword) {
		validate(customer, rawPassword);

		String email = customer.getEmail().trim();
		if (customerDao.findByEmail(email) != null) {
			throw new IllegalArgumentException("Email đã tồn tại: " + email);
		}

		customer.setEmail(email);
		customer.setPasswordHash(PasswordUtils.sha256(rawPassword));
		return customerDao.insert(customer);
	}

	private void validate(Customer customer, String rawPassword) {
		Objects.requireNonNull(customer, "customer must not be null");
		if (customer.getName() == null || customer.getName().trim().isEmpty()) {
			throw new IllegalArgumentException("customer.name must not be blank");
		}
		if (customer.getEmail() == null || customer.getEmail().trim().isEmpty()) {
			throw new IllegalArgumentException("customer.email must not be blank");
		}
		if (rawPassword == null || rawPassword.isEmpty()) {
			throw new IllegalArgumentException("password must not be blank");
		}
	}
}
