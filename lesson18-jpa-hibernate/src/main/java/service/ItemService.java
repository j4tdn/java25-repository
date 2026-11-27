package service;

import java.util.List;

import persistence.Item;

public interface ItemService {
	
	/**
	 * Find all items.
	 * 
	 * @return list of {@code Item}
	 */
	List<Item> getAll();
	
}
