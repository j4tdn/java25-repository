package service;

import persistence.Item;
import java.time.LocalDate;
import java.util.List;

public interface ItemService {

    List<Item> getItems();

    List<Item> getItemsByGroupAndNotSoldOnDate(
            String groupName, LocalDate orderDate);
}
