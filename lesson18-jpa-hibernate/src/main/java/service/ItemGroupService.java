package service;

import java.util.List;

import persistence.ItemGroup;

public interface ItemGroupService {

	/**
	 * Find all item groups
	 * 
	 * @return {@code list of ItemGroup}
	 */
	List<ItemGroup> getAll();
	
	/**
	 * Find item group by id
	 * 
	 * @param id the given id
	 * @return {@code ItemGroup}
	 */
	ItemGroup get(long id);

	/**
	 * Find item group by name
	 * 
	 * @param name the given name
	 * @return {@code ItemGroup}
	 */
	ItemGroup get(String name);

}
