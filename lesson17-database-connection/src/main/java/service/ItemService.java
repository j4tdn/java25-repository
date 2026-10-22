package service;

import java.sql.Date;
import java.util.List;

import persistence.Item;

public interface ItemService {

	List<Item> getByItemGroupNameAndNotSoldDate(String itemGroupName, Date saleDate);

}
