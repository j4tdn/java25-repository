package com.java25.dao;

import com.java25.Dto.ItemDto;
import com.java25.persistence.Item;

import java.util.List;

public class HibernateItemDao extends GenericDao implements ItemDao{
    private final static String Q_GET_ALL = "" +
            "SELECT new com.java25.Dto.ItemDto(\n" +
            "            i.id,\n" +
            "            i.name,\n" +
            "            i.color,\n" +
            "            i.buyPrice,\n" +
            "            i.material,\n" +
            "            g.id,\n" +
            "            g.name,\n" +
            "            g.status\n" +
            "        )\n" +
            "        FROM Item i\n" +
            "        JOIN ItemGroup g ON i.groupId = g.id";

    @Override
    public List<Item> getAll() {
        return openSession()
                .createQuery("FROM Item ", Item.class)
                .getResultList();
    }

    @Override
    public List<ItemDto> getItems() {
        return openSession()
                .createQuery(Q_GET_ALL, ItemDto.class)
                .getResultList();
    }
}
