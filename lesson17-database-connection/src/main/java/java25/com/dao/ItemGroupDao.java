package java25.com.dao;

import java25.com.persistence.ItemGroup;

import java.util.List;

public interface ItemGroupDao {
    /**
     * Find All item groups
     * @author phungvantiendat
     * @return {@code list of ItemGroup}
     */
    List<ItemGroup> findAll();
}
