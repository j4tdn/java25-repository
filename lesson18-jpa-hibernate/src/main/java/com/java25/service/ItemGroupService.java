package com.java25.service;

import com.java25.persistence.ItemGroup;

import java.util.List;

public interface ItemGroupService {
    /**
     * Find all item groups
     *
     * @return {@code list of ItemGroup}
     */
    List<ItemGroup> getAll();

    /**
     * Find Item group by item_group_id
     * @author phungvantiendat
     * @param itemGroupId
     * @return {@code ItemGroup}
     */
    ItemGroup get(Long itemGroupId);

    /**
     * Find Item group by item_group_name
     * @author phungvantiendat
     * @param name
     * @return {@code ItemGroup}
     */
    ItemGroup get(String name);
}
