package com.java25.service;

import com.java25.dao.HibernateItemGroupDao;
import com.java25.dao.ItemGroupDao;
import com.java25.persistence.ItemGroup;

import java.util.List;

public class ItemGroupServiceImpl implements ItemGroupService {

    private final ItemGroupDao itemGroupDao;

    public ItemGroupServiceImpl() {
        itemGroupDao = new HibernateItemGroupDao();
    }

    @Override
    public List<ItemGroup> getAll() {
        return itemGroupDao.getAll();
    }

    @Override
    public ItemGroup get(Long itemGroupId) {
        return itemGroupDao.get(itemGroupId);
    }

    @Override
    public ItemGroup get(String name) {
        return itemGroupDao.get(name);
    }
}
