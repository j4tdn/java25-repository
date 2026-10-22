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
	
	/**
	 * Find all item groups included items
	 * 
	 * @return {@code list of ItemGroup}
	 */
	List<ItemGroup> getItemGroups();

	/**
	 * Find item group by id
	 * 
	 * @param id the given id
	 * @return {@code ItemGroup}
	 */
	ItemGroup get(int id);
	
	/**
	 * Find item group by name
	 * 
	 * @param name the given name
	 * @return {@code ItemGroup}
	 */
	ItemGroup get(String name);

}
