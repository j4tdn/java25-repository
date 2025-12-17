package fa.mockproject.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.mockproject.model.CartItems;

@Repository
public class CartItemDAO implements DAOInterface<CartItems>{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(CartItems t) {
		try {
			String sql = "INSERT INTO [Cart_items] "
					+ "(cartId, bookId, book_name, price, quantity_order, discount, total_price, image_data) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			return jdbcTemplate.update(sql, t.getCartId(), t.getBookId(), t.getBookName(),
					t.getPrice(), t.getQuantityOrder(), t.getDiscount(), t.getTotalPrice(), t.getAvatar());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(CartItems t) {
		try {
			String sql = "UPDATE [Cart_items] " + "SET book_name = ?, price=? , quantity_order = ?, discount = ?, total_price = ?, image_data = ?" + "WHERE cart_itemId = ?";
			return jdbcTemplate.update(sql,t.getBookName(), t.getPrice(), t.getQuantityOrder(), t.getDiscount(), t.getAvatar(), t.getCartItemId());
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(CartItems t) {
		try {
			String sql = "DELETE FROM [Cart_items] WHERE cart_itemId = ?";
			return jdbcTemplate.update(sql, t.getCartItemId());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<CartItems> findAll() {
		try {
			String sql = "SELECT * FROM [Cart_items]";
			return (ArrayList<CartItems>) jdbcTemplate.query(sql, new RowMapper<CartItems>() {
				@Override
				public CartItems mapRow(ResultSet rs, int rowNum) throws SQLException {
					CartItems cartItem = new CartItems();
					cartItem.setCartItemId(UUID.fromString(rs.getString("cart_itemId")));
					cartItem.setCartId(UUID.fromString(rs.getString("cartId")));
					cartItem.setBookId(UUID.fromString(rs.getString("bookId")));
					cartItem.setBookName(rs.getString("book_name"));
					cartItem.setPrice(rs.getBigDecimal("price"));
					cartItem.setQuantityOrder(rs.getInt("quantity_order"));
					cartItem.setDiscount(rs.getBigDecimal("discount"));
					cartItem.setTotalPrice(rs.getBigDecimal("total_price"));
					cartItem.setAvatar(rs.getBytes("image_data"));
					return cartItem;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		
	}

	@Override
	public CartItems findById(CartItems t) {
		try {
			String sql = "SELECT * FROM [Cart_items] WHERE cart_itemsId = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] { t.getCartItemId() }, new RowMapper<CartItems>() {
				@Override
				public CartItems mapRow(ResultSet rs, int rowNum) throws SQLException {
					CartItems cartItem = new CartItems();
					cartItem.setCartItemId(UUID.fromString(rs.getString("cart_itemId")));
					cartItem.setCartId(UUID.fromString(rs.getString("cartId")));
					cartItem.setBookId(UUID.fromString(rs.getString("bookId")));
					cartItem.setBookName(rs.getString("book_name"));
					cartItem.setPrice(rs.getBigDecimal("price"));
					cartItem.setQuantityOrder(rs.getInt("quantity_order"));
					cartItem.setDiscount(rs.getBigDecimal("discount"));
					cartItem.setTotalPrice(rs.getBigDecimal("total_price"));
					cartItem.setAvatar(rs.getBytes("image_data"));
					return cartItem;
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public CartItems findByCartIdAndBookId(CartItems t) {
		try {
			System.out.println("t.cartId: " + t.getCartId());
			System.out.println("t.BookId: " + t.getBookId());
			String sql = "SELECT * FROM [Cart_items] WHERE cartId = ? and bookId = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] { t.getCartId(), t.getBookId()}, new RowMapper<CartItems>() {
				@Override
				public CartItems mapRow(ResultSet rs, int rowNum) throws SQLException {
					CartItems cartItem = new CartItems();
					cartItem.setCartItemId(UUID.fromString(rs.getString("cart_itemId")));
					cartItem.setCartId(UUID.fromString(rs.getString("cartId")));
					cartItem.setBookId(UUID.fromString(rs.getString("bookId")));
					cartItem.setBookName(rs.getString("book_name"));
					cartItem.setPrice(rs.getBigDecimal("price"));
					cartItem.setQuantityOrder(rs.getInt("quantity_order"));
					cartItem.setDiscount(rs.getBigDecimal("discount"));
					cartItem.setTotalPrice(rs.getBigDecimal("total_price"));
					cartItem.setAvatar(rs.getBytes("image_data"));
					return cartItem;
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<CartItems> getListCartItem(UUID userId) {
        try {
            String sql = "SELECT ci.cart_itemId, ci.cartId, ci.bookId, ci.book_name, ci.price, ci.quantity_order, ci.discount, ci.total_price, ci.image_data " +
                    "FROM Cart_items ci " +
                    "JOIN Cart c ON ci.cartId = c.cartId " +
                    "WHERE c.userId = ?";

            return (ArrayList<CartItems>) jdbcTemplate.query(sql, new Object[]{userId}, new RowMapper<CartItems>() {
                @Override
                public CartItems mapRow(ResultSet rs, int rowNum) throws SQLException {
                    CartItems cartItem = new CartItems();
                    cartItem.setCartItemId(UUID.fromString(rs.getString("cart_itemId")));
                    cartItem.setCartId(UUID.fromString(rs.getString("cartId")));
                    cartItem.setBookId(UUID.fromString(rs.getString("bookId")));
                    cartItem.setBookName(rs.getString("book_name"));
                    cartItem.setPrice(rs.getBigDecimal("price"));
                    cartItem.setQuantityOrder(rs.getInt("quantity_order"));
                    cartItem.setDiscount(rs.getBigDecimal("discount"));
                    cartItem.setTotalPrice(rs.getBigDecimal("total_price"));
                    cartItem.setAvatar(rs.getBytes("image_data")); // Sửa lại thành "image_data"
                    return cartItem;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
	public int UpdateCartItem(UUID cartItemId, int quantity, BigDecimal totalPrice) {
		try {
			String sql = "UPDATE [Cart_items] " + "SET quantity_order = ?, total_price = ? " + "WHERE cart_itemId = ?";
			return jdbcTemplate.update(sql, quantity, totalPrice, cartItemId);
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int updateWithBookIdAndCartId( int quantity, BigDecimal totalPrice, UUID bookId, UUID cartId) {
		try {
			String sql = "UPDATE [Cart_items] " + "SET quantity_order = ?, total_price = ? " + "WHERE bookId = ? and cartId = ?";
			return jdbcTemplate.update(sql, quantity, totalPrice, bookId, cartId);
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int deleteCartItem(UUID cartItemId) {
		try {
			String sql = "DELETE FROM [Cart_items] WHERE cart_itemId = ?";
			return jdbcTemplate.update(sql, cartItemId);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int deleteCartItem(String productId) {
		try {
			String sql = "DELETE FROM [Cart_items] WHERE cart_itemId = ?";
			return jdbcTemplate.update(sql, productId);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int UpdateCartItem(String productId, int quantity, double totalPrice) {
		try {
			String sql = "UPDATE [Cart_items] " + "SET quantity_order = ?, total_price = ? " + "WHERE cart_itemId = ?";
			return jdbcTemplate.update(sql, quantity, totalPrice, productId);
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
