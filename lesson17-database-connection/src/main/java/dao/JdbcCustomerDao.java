package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.DbConnection;
import persistence.Customer;
import utils.SqlUtils;

public class JdbcCustomerDao implements CustomerDao {

	private static final String Q_FIND_BY_EMAIL = ""
			+ "SELECT C08_CUSTOMER_ID, C08_CUSTOMER_NAME, C08_CUSTOMER_EMAIL,\n"
			+ "       C08_CUSTOMER_PHONE, C08_CUSTOMER_ADDRESS, C08_CUSTOMER_PASSWORD,\n"
			+ "       C08_SOCIAL_MEDIA, C08_SM_TOKEN\n"
			+ "  FROM t08_customer\n"
			+ " WHERE C08_CUSTOMER_EMAIL = ?";

	private static final String Q_INSERT_CUSTOMER = ""
			+ "INSERT INTO t08_customer\n"
			+ "       (C08_CUSTOMER_NAME, C08_CUSTOMER_EMAIL, C08_CUSTOMER_PHONE,\n"
			+ "        C08_CUSTOMER_ADDRESS, C08_CUSTOMER_PASSWORD, C08_SOCIAL_MEDIA, C08_SM_TOKEN)\n"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

	private final Connection conn;

	public JdbcCustomerDao() {
		conn = DbConnection.getConnection();
	}

	@Override
	public Customer findByEmail(String email) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement(Q_FIND_BY_EMAIL);
			statement.setString(1, email);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return map(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(resultSet, statement);
		}

		return null;
	}

	@Override
	public Customer insert(Customer customer) {
		try (PreparedStatement statement = conn.prepareStatement(
				Q_INSERT_CUSTOMER, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getEmail());
			statement.setString(3, customer.getPhone());
			statement.setString(4, customer.getAddress());
			statement.setString(5, customer.getPasswordHash());
			statement.setString(6, customer.getSocialMedia());
			statement.setString(7, customer.getSocialMediaToken());
			statement.executeUpdate();

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					customer.setId(generatedKeys.getLong(1));
				}
			}
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Customer map(ResultSet resultSet) throws SQLException {
		Customer customer = new Customer(
			resultSet.getLong("C08_CUSTOMER_ID"),
			resultSet.getString("C08_CUSTOMER_NAME"),
			resultSet.getString("C08_CUSTOMER_EMAIL"),
			resultSet.getString("C08_CUSTOMER_PASSWORD")
		);
		customer.setPhone(resultSet.getString("C08_CUSTOMER_PHONE"));
		customer.setAddress(resultSet.getString("C08_CUSTOMER_ADDRESS"));
		customer.setSocialMedia(resultSet.getString("C08_SOCIAL_MEDIA"));
		customer.setSocialMediaToken(resultSet.getString("C08_SM_TOKEN"));
		return customer;
	}
}
