package fa.mockproject.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.dao.CartItemDAO;
import fa.mockproject.model.CartItems;

 @Service
public class CartItemsService implements ServiceInterface<CartItems> {

	@Autowired
	CartItemDAO cartItemsDao;

	@Override
	public int insert(CartItems t) {
		return cartItemsDao.insert(t);
	}

	@Override
	public int update(CartItems t) {
		return cartItemsDao.update(t);
	}

	@Override
	public int delete(CartItems t) {
		return cartItemsDao.delete(t);
	}

	@Override
	public ArrayList<CartItems> findAll() {
		return cartItemsDao.findAll();
	}

	@Override
	public CartItems findById(CartItems t) {
		return cartItemsDao.findById(t);
	}
	
	public CartItems findByCartIdAndBookId(CartItems t) {
		return cartItemsDao.findByCartIdAndBookId(t);
	}
	
	public ArrayList<CartItems> getListCartItem(UUID userId){
		return cartItemsDao.getListCartItem(userId);
	}
	
	public int UpdateCartItem(UUID cartItemId, int quantity, BigDecimal totalPrice) {
		return cartItemsDao.UpdateCartItem(cartItemId, quantity, totalPrice);
	}
	
	public int updateWithBookIdAndCartId( int quantity, BigDecimal totalPrice, UUID bookId, UUID cartId) {
		return cartItemsDao.updateWithBookIdAndCartId(quantity, totalPrice, bookId, cartId);
	}
	
	public int deleteCartItem(UUID cartItemId) {
		return cartItemsDao.deleteCartItem(cartItemId);
	}
	
	public int UpdateCartItem(String productId, int quantity, double totalPrice) {
		return cartItemsDao.UpdateCartItem(productId, quantity, totalPrice);
	}
	
	public int deleteCartItem(String productId) {
		return cartItemsDao.deleteCartItem(productId);
	}
}
