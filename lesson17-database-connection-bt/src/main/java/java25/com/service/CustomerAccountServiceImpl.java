package java25.com.service;

import java.util.Locale;
import java25.com.dao.CustomerAccountDao;
import java25.com.dao.JdbcCustomerAccountDao;
import java25.com.persistence.CustomerAccount;
import java25.com.utils.PasswordUtils;

public class CustomerAccountServiceImpl implements CustomerAccountService {
    private final CustomerAccountDao dao = new JdbcCustomerAccountDao();

    private String normalizeEmail(String email) {
        if (email == null) throw new IllegalArgumentException("Email khong duoc trong.");
        email = email.trim().toLowerCase(Locale.ROOT);
        if (email.length() > 254 || !email.matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+"))
            throw new IllegalArgumentException("Email khong hop le.");
        return email;
    }

    @Override
    public CustomerAccount register(String fullName, String email, String password) {
        if (fullName == null || fullName.trim().isEmpty() || fullName.trim().length() > 150)
            throw new IllegalArgumentException("Ho ten phai tu 1 den 150 ky tu.");
        email = normalizeEmail(email);
        if (password == null || password.length() < 8 || password.length() > 128)
            throw new IllegalArgumentException("Mat khau phai tu 8 den 128 ky tu.");
        return dao.insert(fullName.trim(), email, PasswordUtils.hash(password));
    }

    @Override
    public CustomerAccount login(String email, String password) {
        email = normalizeEmail(email);
        if (password == null || password.isEmpty() || password.length() > 128)
            throw new IllegalArgumentException("Mat khau khong hop le.");
        return dao.login(email, password);
    }
}
