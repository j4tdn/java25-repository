package service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import dao.ItemGroupDao;
import dao.JdbcItemGroupDao;
import persistence.Item;
import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class ItemGroupServiceImpl implements ItemGroupService {
	
	private final ItemGroupDao itemGroupDao;
	private final ItemService itemService;
	
	public ItemGroupServiceImpl() {
		this.itemGroupDao = new JdbcItemGroupDao();
		itemService = new ItemServiceImpl();
	}
	
	@Override
	public List<ItemGroup> getAll() {
		return itemGroupDao.getAll();
	}
	
	@Override
	public List<ItemGroup> getItemGroups() {
		// Option 1: Invoke DAO directly
		// return itemGroupDao.getItemGroups(); 
		
		// Option 2: Invoke DAO with basic DATA & process logic in SERVICE
		List<Item> items = itemService.getItems();
		
		Map<ItemGroup, List<Item>> groupOfItems = items.stream()
				.collect(Collectors.groupingBy(Item::getGroup));
		
		return groupOfItems.entrySet().stream()
					.map(e -> new ItemGroup(e.getKey(), e.getValue()))
					.collect(Collectors.toList());
	}
	
	@Override
	public List<ItemGroupDto> countItemsPerGroup() {
		return itemGroupDao.countItemsPerGroup();
	}
	
	@Override
	public ItemGroup get(long id) {
		return itemGroupDao.get(id);
	}
	
	@Override
	public ItemGroup get(String name) {
		Objects.requireNonNull(name, "name must not be null");
		return itemGroupDao.get(name);
	}
	
	@Override
	public void save(ItemGroup group) {
		Objects.requireNonNull(group, "group must not be null");
		itemGroupDao.save(group);
	}
	
	@Override
	public void save(List<ItemGroup> groups) {
		Objects.requireNonNull(groups, "groups must not be null");
		if (!groups.isEmpty()) {
			itemGroupDao.save(groups);
		}
	}
	 
	@Override
	public void update(ItemGroup group) {
		Objects.requireNonNull(group, "group must not be null");
		itemGroupDao.update(group);
	}
	
	@Override
	public void saveOrUpdate(ItemGroup group) {
		Long id = group.getId();
		if (id == null) {
			save(group);
			return;
		}
		if (get(id) == null) {
			save(group);
		} else {
			update(group);
		}
	}
	
}
