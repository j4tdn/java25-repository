package java25.com.service;

import java25.com.persistence.CustomerAccount;

public interface CustomerAccountService {
    CustomerAccount register(String fullName, String email, String password);
    CustomerAccount login(String email, String password);
}
