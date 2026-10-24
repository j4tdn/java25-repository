package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.DbConnection;

public class JdbcCustomerAccountDao implements CustomerAccountDao {

    private static final String INSERT =
            "INSERT INTO LESSON17_CUSTOMER_ACCOUNT (email, password_hash) VALUES (?, ?)";
    private static final String FIND_BY_EMAIL =
            "SELECT id, email, password_hash FROM LESSON17_CUSTOMER_ACCOUNT WHERE email = ?";

    private Connection connection() throws SQLException {
        Connection connection = DbConnection.getConnection();
        if (connection == null || connection.isClosed()) {
            throw new SQLException("Không kết nối được MySQL. Kiểm tra db-config.properties.");
        }
        return connection;
    }

    @Override
    public long create(String email, String passwordHash) throws SQLException {
        try (PreparedStatement statement = connection().prepareStatement(
                INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, email);
            statement.setString(2, passwordHash);
            statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getLong(1);
                }
            }
        }
        throw new SQLException("Đã thêm tài khoản nhưng không đọc được mã tài khoản.");
    }

    @Override
    public CustomerCredentialRow findByEmail(String email) throws SQLException {
        try (PreparedStatement statement = connection().prepareStatement(FIND_BY_EMAIL)) {
            statement.setString(1, email);
            try (ResultSet rows = statement.executeQuery()) {
                if (rows.next()) {
                    return new CustomerCredentialRow(
                            rows.getLong("id"),
                            rows.getString("email"),
                            rows.getString("password_hash"));
                }
            }
        }
        return null;
    }
}
