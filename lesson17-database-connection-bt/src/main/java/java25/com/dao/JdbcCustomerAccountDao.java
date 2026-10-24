package java25.com.dao;

import java25.com.connection.DbConnection;
import java25.com.persistence.CustomerAccount;
import java25.com.utils.PasswordUtils;
import java.sql.*;

public class JdbcCustomerAccountDao implements CustomerAccountDao {
    @Override
    public CustomerAccount insert(String fullName, String email, String passwordHash) {
        String sql = "INSERT INTO LESSON17_CUSTOMER_ACCOUNT (FULL_NAME, EMAIL, PASSWORD_HASH) VALUES (?, ?, ?)";
        try (Connection connection = DbConnection.openConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, fullName);
            statement.setString(2, email);
            statement.setString(3, passwordHash);
            if (statement.executeUpdate() != 1) throw new SQLException("Khong them duoc tai khoan");
            try (ResultSet result = statement.getGeneratedKeys()) {
                if (result.next()) return new CustomerAccount(result.getLong(1), fullName, email);
                throw new SQLException("Khong lay duoc ID tai khoan");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException("Email da duoc dang ky.", e);
        } catch (SQLException e) {
            throw new IllegalStateException("Khong tao duoc tai khoan. Kiem tra database.", e);
        }
    }

    @Override
    public CustomerAccount login(String email, String password) {
        String sql = "SELECT ACCOUNT_ID, FULL_NAME, EMAIL, PASSWORD_HASH "
                + "FROM LESSON17_CUSTOMER_ACCOUNT WHERE EMAIL = ?";
        try (Connection connection = DbConnection.openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next() && PasswordUtils.verify(password, result.getString("PASSWORD_HASH"))) {
                    return new CustomerAccount(result.getLong("ACCOUNT_ID"),
                            result.getString("FULL_NAME"), result.getString("EMAIL"));
                }
                return null;
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Khong dang nhap duoc. Kiem tra database.", e);
        }
    }
}
