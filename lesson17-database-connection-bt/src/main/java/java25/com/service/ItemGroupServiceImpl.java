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

    private void validate(ItemGroup group) {
        if (group == null || group.getId() == null || group.getId() <= 0)
            throw new IllegalArgumentException("Ma loai hang phai lon hon 0.");
        if (group.getName() == null || group.getName().trim().isEmpty())
            throw new IllegalArgumentException("Ten loai hang khong duoc trong.");
        if (group.getStatus() == null)
            throw new IllegalArgumentException("Trang thai khong hop le.");
        group.setName(group.getName().trim());
    }

    @Override
    public int insert(ItemGroup group) {
        validate(group);
        return itemGroupDao.insert(group);
    }

    @Override
    public int update(ItemGroup group) {
        validate(group);
        return itemGroupDao.update(group);
    }

    @Override
    public int save(ItemGroup group) {
        validate(group);
        return itemGroupDao.save(group);
    }

    @Override
    public int insertBatch(List<ItemGroup> groups) {
        if (groups == null || groups.isEmpty())
            throw new IllegalArgumentException("Danh sach loai hang khong duoc rong.");
        java.util.Set<Long> ids = new java.util.HashSet<>();
        for (ItemGroup group : groups) {
            validate(group);
            if (!ids.add(group.getId()))
                throw new IllegalArgumentException("Trung ma loai hang trong danh sach.");
        }
        return itemGroupDao.insertBatch(groups);
    }
}
