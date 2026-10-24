package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;

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