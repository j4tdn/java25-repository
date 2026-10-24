package java25.com.dao;

import java25.com.persistence.Customer;

public interface CustomerDao {
    boolean createAccount(Customer request);
}
