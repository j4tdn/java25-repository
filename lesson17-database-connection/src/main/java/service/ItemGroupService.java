package service;

import java.util.List;
import java.sql.SQLException;

import dao.ItemGroupDto;
import persistence.ItemGroup;

public interface ItemGroupService {
    List<ItemGroup> findAll();
    ItemGroup findById(Long itemGroupId);
    ItemGroup findByName(String name);

    List<ItemGroup> getItemGroups();
    List<ItemGroupDto> countItemsPerGroup(int amount);

    ItemGroup create(ItemGroup group) throws SQLException;
    boolean update(ItemGroup group) throws SQLException;
    ItemGroup save(ItemGroup group) throws SQLException;
    int createMany(List<ItemGroup> groups) throws SQLException;
}
