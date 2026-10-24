package dao;

import connection.DbConnection;
import persistence.Customer;
import utils.PasswordUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCustomerDao implements CustomerDao {

    private final Connection conn;

    public JdbcCustomerDao() {
        conn = DbConnection.getConnection();
    }

    @Override
    public boolean add(Customer customer) {
        /*
         * Gia dinh schema: T13_CUSTOMER(
         * C13_CUSTOMER_ID, C13_CUSTOMER_NAME, C13_EMAIL, C13_PASSWORD
         * )
         * Neu database cua ban dung ten cot/bang khac, sua SQL nay theo schema that.
         */
        String sql = "INSERT INTO T13_CUSTOMER " +
                "(C13_CUSTOMER_NAME, C13_EMAIL, C13_PASSWORD) VALUES (?, ?, ?)";

        if (conn == null) {
            return false;
        }

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, customer.getName());
            pst.setString(2, customer.getEmail());
            pst.setString(3, PasswordUtils.hashPassword(customer.getPassword()));

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Customer getByEmail(String email) {
        String sql = "SELECT C13_CUSTOMER_ID, C13_CUSTOMER_NAME, " +
                "C13_EMAIL, C13_PASSWORD FROM T13_CUSTOMER WHERE C13_EMAIL = ?";

        if (conn == null) {
            return null;
        }

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, email);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                            rs.getLong("C13_CUSTOMER_ID"),
                            rs.getString("C13_CUSTOMER_NAME"),
                            rs.getString("C13_EMAIL"),
                            rs.getString("C13_PASSWORD")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
