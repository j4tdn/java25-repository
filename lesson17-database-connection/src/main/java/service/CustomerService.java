package service;

import persistence.Customer;

public interface CustomerService {

    boolean register(String name, String email, String password);

    Customer login(String email, String password);
}
