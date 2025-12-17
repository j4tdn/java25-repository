package fa.mockproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.mockproject.model.Cart;

@Repository
public class CartDAO implements DAOInterface<Cart>{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int insert(Cart t) {
		try {
			String sql = "INSERT INTO [Cart] "
					+ "(userId, price, total_discount, total_price, status)"
					+ "VALUES (?, ?, ?, ?, ?)";

			return jdbcTemplate.update(sql, t.getUserId(), t.getPrice(), t.getTotalDiscount(), t.getTotalPrice(),
					t.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Cart t) {
		try {
			String sql = "UPDATE [Cart] " + "SET price = ?, total_discount = ?, total_price =?, status =? " + "WHERE cartId = ?";
			return jdbcTemplate.update(sql,t.getPrice(), t.getTotalDiscount(), t.getTotalPrice(), t.getStatus(), t.getCartId());
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(Cart t) {
		try {
			String sql = "DELETE FROM [Cart] WHERE cartId = ?";
			return jdbcTemplate.update(sql, t.getCartId());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<Cart> findAll() {
		try {
			String sql = "SELECT * FROM [Cart]";
			return (ArrayList<Cart>) jdbcTemplate.query(sql, new RowMapper<Cart>() {
				@Override
				public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cart cart = new Cart();
					cart.setCartId(UUID.fromString(rs.getString("cartId")));
					cart.setUserId(UUID.fromString(rs.getString("userId")));
					cart.setPrice(rs.getBigDecimal("price"));
					cart.setTotalDiscount(rs.getBigDecimal("total_discount"));
					cart.setTotalPrice(rs.getBigDecimal("total_price"));
					cart.setStatus(rs.getString("status"));
					return cart;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public Cart findById(Cart t) {
		try {
			String sql = "SELECT * FROM [Cart] WHERE cartId = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] { t.getCartId() }, new RowMapper<Cart>() {
				@Override
				public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cart cart = new Cart();
					cart.setCartId(UUID.fromString(rs.getString("cartId")));
					cart.setUserId(UUID.fromString(rs.getString("userId")));
					cart.setPrice(rs.getBigDecimal("price"));
					cart.setTotalDiscount(rs.getBigDecimal("total_discount"));
					cart.setTotalPrice(rs.getBigDecimal("total_price"));
					cart.setStatus(rs.getString("status"));
					return cart;
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Cart findByUserId(Cart t) {
		try {
			String sql = "SELECT * FROM [Cart] WHERE userId = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] { t.getUserId() }, new RowMapper<Cart>() {
				@Override
				public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cart cart = new Cart();
					cart.setCartId(UUID.fromString(rs.getString("cartId")));
					cart.setUserId(UUID.fromString(rs.getString("userId")));
					cart.setPrice(rs.getBigDecimal("price"));
					cart.setTotalDiscount(rs.getBigDecimal("total_discount"));
					cart.setTotalPrice(rs.getBigDecimal("total_price"));
					cart.setStatus(rs.getString("status"));
					return cart;
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UUID getCartIDbyUserID(String id_user) {
        try {
            String sql = "SELECT cartId FROM Cart WHERE userId = ?";
            UUID userId = UUID.fromString(id_user); 
            return jdbcTemplate.queryForObject(sql, UUID.class, userId);

        }
        catch (Exception e) {
            e.printStackTrace();
            return null; // Handle other exceptions
        }
    }

}