package service;

import java.sql.SQLException;
import java.util.List;

import dao.ItemGroupDao;
import dao.ItemGroupDto;
import dao.JdbcItemGroupDao;
import persistence.Item;
import persistence.ItemGroup;

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
        return itemGroupDao.findAll().stream()
                .map(group -> new ItemGroup(group, groupOfItems.getOrDefault(group, List.of())))
                .collect(Collectors.toList());
    }

    @Override
    public List<ItemGroupDto> countItemsPerGroup(int amount) {
        return itemGroupDao.countItemsPerGroup(amount);
    }

    private void validate(ItemGroup group) {
        if (group == null || group.getName() == null || group.getName().isBlank()
                || group.getStatus() == null) {
            throw new IllegalArgumentException("Tên và trạng thái loại hàng không được để trống.");
        }
        if (group.getId() != null && group.getId() <= 0) {
            throw new IllegalArgumentException("Mã loại hàng phải lớn hơn 0.");
        }
    }

    @Override
    public ItemGroup create(ItemGroup group) throws SQLException {
        validate(group);
        return itemGroupDao.create(group);
    }

    @Override
    public boolean update(ItemGroup group) throws SQLException {
        validate(group);
        if (group.getId() == null || group.getId() <= 0) {
            throw new IllegalArgumentException("Cần mã loại hàng hợp lệ để sửa.");
        }
        return itemGroupDao.update(group);
    }

    @Override
    public ItemGroup save(ItemGroup group) throws SQLException {
        validate(group);
        return itemGroupDao.save(group);
    }

    @Override
    public int createMany(List<ItemGroup> groups) throws SQLException {
        if (groups == null || groups.isEmpty()) {
            throw new IllegalArgumentException("Danh sách loại hàng không được rỗng.");
        }
        groups.forEach(this::validate);
        return itemGroupDao.createMany(groups);
    }
}
