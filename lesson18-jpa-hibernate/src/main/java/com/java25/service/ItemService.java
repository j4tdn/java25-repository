package com.java25.service;


import com.java25.Dto.ItemDto;
import com.java25.persistence.Item;

import java.util.List;

public interface ItemService {

    /**
     * find all items included group
     *
     * @return {@code list of items}
     */
    List<ItemDto> getItems();

    /**
     * find all items exclude group
     *
     * @return {@code list of items}
     */
    List<Item> getAll();

}
