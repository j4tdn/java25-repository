package service;

import java.time.LocalDate;
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
	public List<Item> getItemsByGroupAndSalesDate(String groupName, LocalDate salesDate) {
		Objects.requireNonNull(groupName, "groupName should not be null");
		Objects.requireNonNull(salesDate, "salesDate should not be null");
		return itemDao.getItemsByGroupAndSalesDate(groupName, salesDate);
	}

}
