package dao;

import java.sql.Date;
import java.util.List;

import persistence.Item;

public interface ItemDao {

	/**
	 * Find items in the given item group and not sold on {@code saleDate}.
	 *
	 * @param itemGroupName the item group name as text
	 * @param saleDate the date on which the item must not be sold
	 * @return matching items
	 */
	List<Item> getByItemGroupNameAndNotSoldDate(String itemGroupName, Date saleDate);

}
