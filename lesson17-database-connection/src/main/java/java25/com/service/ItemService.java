package java25.com.service;

import java25.com.persistence.Item;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {

    /**
     * find all items included group
     *
     * @return {@code list of items}
     */
    List<Item> getItems();

    /**
     * Get items which belong to the specified group
     *      and not sell in the given sales date
     * @param groupName the name of group
     * @param salesDate the given sales date
     *
     * @return {@code list of Item}
     */
    List<Item> getItemsByGroupAndNotSoldOnDate(String groupName, LocalDate salesDate);
}
