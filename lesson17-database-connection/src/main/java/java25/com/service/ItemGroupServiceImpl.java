package java25.com.service;

import java25.com.dao.ItemGroupDao;
import java25.com.dao.ItemGroupDto;
import java25.com.dao.JdbcItemGroupDao;
import java25.com.persistence.Item;
import java25.com.persistence.ItemGroup;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemGroupServiceImpl implements ItemGroupService {
    private final ItemGroupDao itemGroupDao;
    private final ItemService itemService;

    public ItemGroupServiceImpl() {
        this.itemGroupDao = new JdbcItemGroupDao();
        itemService = new ItemServiceImpl();
    }

    @Override
    public List<ItemGroup> findAll() {
        return itemGroupDao.findAll();
    }

    @Override
    public ItemGroup findById(Long itemGroupId) {
        return itemGroupDao.findById(itemGroupId);
    }

    @Override
    public ItemGroup findByName(String name) {
        return itemGroupDao.findByName(name);
    }



    @Override
    public List<ItemGroup> getItemGroups() {
        List<Item> items = itemService.getItems();
        Map<ItemGroup, List<Item>> groupOfItems = items.stream()
                .collect(Collectors.groupingBy(Item::getGroup));
        return groupOfItems.entrySet()
                .stream()
                .map(e -> new ItemGroup(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ItemGroupDto> countItemsPerGroup(int amount) {
        return itemGroupDao.countItemsPerGroup(amount);
    }
}
