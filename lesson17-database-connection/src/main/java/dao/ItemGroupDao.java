package dao;

import java.util.List;
import java.sql.SQLException;

import persistence.ItemGroup;

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

    ItemGroup create(ItemGroup group) throws SQLException;

    boolean update(ItemGroup group) throws SQLException;

    ItemGroup save(ItemGroup group) throws SQLException;

    int createMany(List<ItemGroup> groups) throws SQLException;
}
