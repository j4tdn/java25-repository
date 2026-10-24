package java25.com.dao;

import java25.com.persistence.Item;

import java.time.LocalDate;
import java.util.List;

public interface ItemDao {

    /**
     * find all items included group
     *
     * @return {@code list of items}
     */
    List<Item> getItems();

    /**
     *
     * @param groupName
     * @param orderDate
     *
     * @return {@code list of Item}
     */
    List<Item> getItemsByGroupAndNotSoldOnDate(String groupName, LocalDate orderDate);

}
