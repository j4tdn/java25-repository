package service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import dao.ItemDao;
import dao.JdbcItemDao;
import persistence.Item;

public class ItemServiceImpl implements ItemService {

	private final ItemDao itemDao;

	public ItemServiceImpl() {
		itemDao = new JdbcItemDao();
	}

	@Override
	public List<Item> getItems() {
		return itemDao.getItems();
	}

	@Override
	public List<Item> getByItemGroupNameAndNotSoldDate(String itemGroupName, Date saleDate) {
		Objects.requireNonNull(itemGroupName, "itemGroupName must not be null");
		Objects.requireNonNull(saleDate, "saleDate must not be null");
		return itemDao.getByItemGroupNameAndNotSoldDate(itemGroupName, saleDate);
	}

}
