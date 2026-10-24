package dao;

import persistence.Customer;

public interface CustomerDao {

	Customer findByEmail(String email);

	Customer insert(Customer customer);
}
