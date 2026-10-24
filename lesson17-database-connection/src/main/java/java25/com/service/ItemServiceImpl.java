package java25.com.service;

import java25.com.dao.ItemDao;
import java25.com.dao.JdbcItemDao;
import java25.com.persistence.Item;

import java.util.List;

public class ItemServiceImpl implements ItemService{
   private final ItemDao itemDao;

   public ItemServiceImpl() {
       itemDao = new JdbcItemDao();
   }

    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }
}
