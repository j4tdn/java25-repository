package dao;

import java.util.List;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

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

	List<ItemGroupDto> countItemsPerGroup(int amount);

	/**
	 * Insert a new item group.
	 *
	 * @param itemGroup item group to insert
	 * @return the inserted item group with its generated id
	 */
	ItemGroup insert(ItemGroup itemGroup);

	/**
	 * Update an existing item group by id.
	 *
	 * @param itemGroup item group to update
	 * @return the updated item group, or {@code null} when no id was found
	 */
	ItemGroup update(ItemGroup itemGroup);

	/**
	 * Insert when the id is null, otherwise update by id.
	 *
	 * @param itemGroup item group to save
	 * @return the saved item group
	 */
	ItemGroup save(ItemGroup itemGroup);

}
