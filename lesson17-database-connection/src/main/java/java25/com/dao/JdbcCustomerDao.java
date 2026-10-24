package java25.com.dao;

import java25.com.persistence.Customer;
import java25.com.utils.PasswordUtils;

import java.sql.SQLException;

public class JdbcCustomerDao extends GenericDao implements CustomerDao {

    private static final String Q_INSERT_CUSTOMER =
            "INSERT INTO T08_CUSTOMER (" +
                    "    C08_CUSTOMER_NAME, " +
                    "    C08_CUSTOMER_EMAIL, " +
                    "    C08_CUSTOMER_PHONE, " +
                    "    C08_CUSTOMER_ADDRESS, " +
                    "    C08_CUSTOMER_PASSWORD, " +
                    "    C08_SOCIAL_MEDIA, " +
                    "    C08_SM_TOKEN" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?)";

    @Override
    public boolean createAccount(Customer request) {
        if (request.getId() == null) {
            return modify(Q_INSERT_CUSTOMER, pst -> {
                try {
                    String hashedPassword = PasswordUtils.hashPassword(request.getPassword());
                    pst.setString(1, request.getName());
                    pst.setString(2, request.getEmail());
                    pst.setString(3, request.getPhone());
                    pst.setString(4, request.getAddress());
                    pst.setString(5, hashedPassword);
                    pst.setString(6, request.getSocialMedia());
                    pst.setString(7, request.getSmToken());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return false;
    }
}
