package java25.com.service;

import java25.com.dao.ItemGroupDto;
import java25.com.dto.ItemJoinItemGroup;
import java25.com.persistence.ItemGroup;

import java.util.List;

public interface ItemGroupService {
    List<ItemGroup> findAll();
    ItemGroup findById(Long itemGroupId);
    ItemGroup findByName(String name);
//    List<ItemJoinItemGroup> findAllWithItem();
    List<ItemGroup> getItemGroups();
    List<ItemGroupDto> countItemsPerGroup(int amount);

    int insert(ItemGroup group);
    int update(ItemGroup group);
    int save(ItemGroup group);
    int insertBatch(List<ItemGroup> groups);
}
