package java25.com.service;

import java25.com.dao.ItemDao;
import java25.com.dao.JdbcItemDao;
import java25.com.persistence.Item;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ItemServiceImpl implements ItemService{
   private final ItemDao itemDao;

   public ItemServiceImpl() {
       itemDao = new JdbcItemDao();
   }

    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }

    @Override
    public List<Item> getItemsByGroupAndNotSoldOnDate(String groupName, LocalDate salesDate) {
        Objects.requireNonNull(groupName, "groupName should not be null!");
        Objects.requireNonNull(salesDate, "salesDate is required!");
        return itemDao.getItemsByGroupAndNotSoldOnDate(groupName, salesDate);
    }
}
