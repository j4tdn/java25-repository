package service;

import java.util.List;
import java.util.Objects;

import dao.ItemGroupDao;
import dao.JdbcItemGroupDao;
import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class ItemGroupServiceImpl implements ItemGroupService {
	
	private final ItemGroupDao itemGroupDao;
	
	public ItemGroupServiceImpl() {
		this.itemGroupDao = new JdbcItemGroupDao();
	}
	
	@Override
	public List<ItemGroup> getAll() {
		return itemGroupDao.getAll();
	}
	
	@Override
	public List<ItemGroup> getItemGroups() {
		return itemGroupDao.getItemGroups();
	}
	
	@Override
	public ItemGroup get(int id) {
		return itemGroupDao.get(id);
	}
	
	@Override
	public ItemGroup get(String name) {
		Objects.requireNonNull(name, "name must not be null");
		return itemGroupDao.get(name);
	}

	@Override
	public List<ItemGroupDto> countItemsPerGroup(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("amount must not be negative");
		}
		return itemGroupDao.countItemsPerGroup(amount);
	}

	@Override
	public ItemGroup insert(ItemGroup itemGroup) {
		validate(itemGroup);
		return itemGroupDao.insert(itemGroup);
	}

	@Override
	public ItemGroup update(ItemGroup itemGroup) {
		validate(itemGroup);
		if (itemGroup.getId() == null) {
			throw new IllegalArgumentException("itemGroup.id must not be null when updating");
		}
		return itemGroupDao.update(itemGroup);
	}

	@Override
	public ItemGroup save(ItemGroup itemGroup) {
		validate(itemGroup);
		return itemGroupDao.save(itemGroup);
	}

	private void validate(ItemGroup itemGroup) {
		Objects.requireNonNull(itemGroup, "itemGroup must not be null");
		if (itemGroup.getName() == null || itemGroup.getName().trim().isEmpty()) {
			throw new IllegalArgumentException("itemGroup.name must not be blank");
		}
		Objects.requireNonNull(itemGroup.getStatus(), "itemGroup.status must not be null");
	}
	
}
