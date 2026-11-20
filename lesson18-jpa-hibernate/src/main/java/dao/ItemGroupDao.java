package dao;

import java.util.List;

import persistence.ItemGroup;

public interface ItemGroupDao {
	/**
	 * Find all item groups
	 * 
	 * @return {@code list of ItemGroup}
	 */
	List<ItemGroup> getAll();
}
