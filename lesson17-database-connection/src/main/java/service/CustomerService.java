package service;

import persistence.Customer;

public interface CustomerService {
	
	/**
	 * Save a new customer
	 * 
	 * @param customer the given customer
	 */
	void save(Customer customer);
	
	/**
	 * Verify account by email and password
	 * 
	 * @param email    the email
	 * @param password the password
	 * @return {@link Customer} if exists
	 */
	Customer login(String email, String password);
}
