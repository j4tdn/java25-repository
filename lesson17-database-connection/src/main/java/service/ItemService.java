package service;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;

public interface ItemService {
	
	/**
	 * Find all items included group
	 * 
	 * @return {@code list of Item}
	 */
	List<Item> getItems();
	
	/**
	 * Get items which belong to the specified group 
	 *     and not sell in the given sales date
	 * @param groupName the name of group
	 * @param salesDate the given sales date
	 *
	 * @return {@code list of Item}
	 */
	List<Item> getItemsByGroupAndSalesDate(String groupName, LocalDate salesDate);
	
}
