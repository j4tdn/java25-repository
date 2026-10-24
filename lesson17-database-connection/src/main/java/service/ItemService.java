package service;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;

public interface ItemService {
    List<Item> getItems();

    List<Item> getItemsByGroupAndNotSoldOnDate(String groupName, LocalDate orderDate);
}
