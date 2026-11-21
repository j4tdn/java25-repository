package com.java25.service;



import com.java25.Dto.ItemDto;
import com.java25.dao.HibernateItemDao;
import com.java25.dao.ItemDao;
import com.java25.persistence.Item;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ItemServiceImpl implements ItemService{
   private final ItemDao itemDao;

   public ItemServiceImpl() {
       itemDao = new HibernateItemDao();
   }


    @Override
    public List<ItemDto> getItems() {
        return itemDao.getItems();
    }

    @Override
    public List<Item> getAll() {
        return itemDao.getAll();
    }
}
