package java25.com.dao;

import java25.com.dto.ItemJoinItemGroup;
import java25.com.persistence.ItemGroup;

import java.util.List;

public interface ItemGroupDao {
    /**
     * Find All item groups
     * @author phungvantiendat
     * @return {@code list of ItemGroup}
     */
    List<ItemGroup> findAll();

    /**
     * Find Item group by item_group_id
     * @author phungvantiendat
     * @param itemGroupId
     * @return {@code ItemGroup}
     */
    ItemGroup findById(Long itemGroupId);

    /**
     * Find Item group by item_group_name
     * @author phungvantiendat
     * @param name
     * @return {@code ItemGroup}
     */
    ItemGroup findByName(String name);

    /**
     * Count Amount of items per group
     *
     * @return {@code list of item group dto}
     */
    List<ItemGroupDto> countItemsPerGroup(int amount);
}
