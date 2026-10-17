package service;

import java.util.List;
import java.util.Objects;

import dao.ItemGroupDao;
import dao.JdbcItemGroupDao;
import persistence.ItemGroup;

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
	
}
