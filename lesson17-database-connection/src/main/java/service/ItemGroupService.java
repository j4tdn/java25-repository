package service;

import java.util.List;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

public interface ItemGroupService {
	
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
	 * Count amount of items per group
	 * 
	 * @return {@code list of ItemGroupDto}
	 */
	List<ItemGroupDto> countItemsPerGroup();
	
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
