package service;

import java.sql.SQLException;
import java.util.Optional;

import persistence.CustomerAccount;

public interface CustomerAccountService {
    CustomerAccount register(String email, char[] password) throws SQLException;

    Optional<CustomerAccount> login(String email, char[] password) throws SQLException;
}
