package java25.com.service;

import java25.com.dao.ItemGroupDao;
import java25.com.dao.JdbcItemGroupDao;
import java25.com.persistence.ItemGroup;

import java.util.List;

public class ItemGroupServiceImpl implements ItemGroupService {
    private final ItemGroupDao itemGroupDao;

    public ItemGroupServiceImpl() {
        this.itemGroupDao = new JdbcItemGroupDao();
    }

    @Override
    public List<ItemGroup> findAll() {
        return itemGroupDao.findAll();
    }
}
