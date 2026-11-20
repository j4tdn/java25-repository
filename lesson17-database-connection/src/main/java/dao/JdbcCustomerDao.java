package dao;

import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import persistence.Customer;

public class JdbcCustomerDao extends GenericDao implements CustomerDao {

	private static final String Q_INSERT_CUSTOMER = ""
			+ "INSERT INTO t08_customer (C08_CUSTOMER_NAME, C08_CUSTOMER_EMAIL, C08_CUSTOMER_PHONE, C08_CUSTOMER_ADDRESS, C08_CUSTOMER_PASSWORD, C08_SOCIAL_MEDIA, C08_SM_TOKEN)\n"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

	private static final String Q_VERIFY_ACCOUNT = "" + "SELECT *\n" + "  FROM t08_customer\n"
			+ " WHERE C08_CUSTOMER_EMAIL = ?\n" + "   AND C08_CUSTOMER_PASSWORD = ?";

	@Override
	public void save(Customer customer) {
		System.out.println(">> Saving new customer " + customer.getName());
		executeUpdate(Q_INSERT_CUSTOMER, pst -> {
			try {
				pst.setString(1, customer.getName());
				pst.setString(2, customer.getEmail());
				pst.setString(3, customer.getPhone());
				pst.setString(4, customer.getAddress());
				pst.setString(5, DigestUtils.sha256Hex(customer.getPassword()));
				pst.setString(6, customer.getSocialMedia());
				pst.setString(7, customer.getToken());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public Customer login(String email, String password) {
		return get(Q_VERIFY_ACCOUNT, pst -> {
			try {
				pst.setString(1, email);
				pst.setString(2, DigestUtils.sha256Hex(password));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}, rs -> {
			Customer customer = null;
			try {
				customer = Customer.newInstance().withId(rs.getLong("C08_CUSTOMER_ID"))
						.withName(rs.getString("C08_CUSTOMER_NAME"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return customer;
		});
	}
}
