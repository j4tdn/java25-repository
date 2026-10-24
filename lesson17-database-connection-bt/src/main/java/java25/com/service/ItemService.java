package java25.com.service;

import java25.com.persistence.Item;

import java.util.List;

public interface ItemService {

    /**
     * find all items included group
     *
     * @return {@code list of items}
     */
    List<Item> getItems();
}
