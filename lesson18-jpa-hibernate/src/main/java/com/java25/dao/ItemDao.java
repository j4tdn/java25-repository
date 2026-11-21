package com.java25.dao;

import com.java25.Dto.ItemDto;
import com.java25.persistence.Item;

import java.util.List;

public interface ItemDao {
    /**
     * find all items exclude group
     *
     * @return {@code list of items}
     */
    List<Item> getAll();

    /**
     * find all items included group
     *
     * @return {@code list of items}
     */
    List<ItemDto> getItems();
}
