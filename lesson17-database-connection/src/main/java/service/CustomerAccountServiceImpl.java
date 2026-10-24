package service;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Optional;

import dao.CustomerAccountDao;
import dao.CustomerCredentialRow;
import dao.JdbcCustomerAccountDao;
import persistence.CustomerAccount;
import utils.PasswordHasher;

public class CustomerAccountServiceImpl implements CustomerAccountService {

    private final CustomerAccountDao accountDao = new JdbcCustomerAccountDao();

    private String normalizeEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email không được để trống.");
        }
        String result = email.trim().toLowerCase(Locale.ROOT);
        if (result.length() > 255 || !result.matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+")) {
            throw new IllegalArgumentException("Email không hợp lệ.");
        }
        return result;
    }

    @Override
    public CustomerAccount register(String email, char[] password) throws SQLException {
        String normalized = normalizeEmail(email);
        if (password == null || password.length < 8 || password.length > 1024) {
            throw new IllegalArgumentException("Mật khẩu phải có từ 8 đến 1024 ký tự.");
        }
        if (accountDao.findByEmail(normalized) != null) {
            throw new IllegalArgumentException("Email đã được đăng ký.");
        }
        String passwordHash = PasswordHasher.hash(password);
        long id = accountDao.create(normalized, passwordHash);
        return new CustomerAccount(id, normalized);
    }

    @Override
    public Optional<CustomerAccount> login(String email, char[] password) throws SQLException {
        String normalized = normalizeEmail(email);
        if (password == null) {
            return Optional.empty();
        }
        CustomerCredentialRow row = accountDao.findByEmail(normalized);
        if (row != null && PasswordHasher.verify(password, row.passwordHash())) {
            return Optional.of(new CustomerAccount(row.id(), row.email()));
        }
        return Optional.empty();
    }
}
