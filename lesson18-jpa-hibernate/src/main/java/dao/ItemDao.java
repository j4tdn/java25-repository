package dao;

import java.util.List;

import persistence.Item;

public interface ItemDao {

	/**
	 * Find all items.
	 * 
	 * @return list of {@code Item}
	 */
	List<Item> getAll();
}
