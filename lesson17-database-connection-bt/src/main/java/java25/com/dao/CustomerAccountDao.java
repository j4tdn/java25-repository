package java25.com.dao;

import java25.com.persistence.CustomerAccount;

public interface CustomerAccountDao {
    CustomerAccount insert(String fullName, String email, String passwordHash);
    CustomerAccount login(String email, String password);
}
