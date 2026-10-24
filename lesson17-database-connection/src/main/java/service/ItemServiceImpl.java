package service;

import dao.ItemDao;
import dao.JdbcItemDao;
import persistence.Item;

import java.time.LocalDate;
import java.util.List;

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
    public List<Item> getItemsByGroupAndNotSoldOnDate(
            String groupName, LocalDate orderDate) {
        return itemDao.getItemsByGroupAndNotSoldOnDate(groupName, orderDate);
    }
}
