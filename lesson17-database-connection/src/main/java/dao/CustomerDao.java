package dao;

import persistence.Customer;

public interface CustomerDao {

    boolean add(Customer customer);

    Customer getByEmail(String email);
}
