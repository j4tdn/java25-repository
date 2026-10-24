package service;

import persistence.Customer;

public interface CustomerService {

	Customer createAccount(Customer customer, String rawPassword);
}
