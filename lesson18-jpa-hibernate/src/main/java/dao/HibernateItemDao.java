package dao;

import java.util.List;

import persistence.Item;

public class HibernateItemDao extends GenericDao implements ItemDao {

	private static final String Q_GET_ITEMS = "" 
			+ "SELECT * FROM t01_item";

	@Override
	public List<Item> getAll() {
		return openSession()
				.createNativeQuery(Q_GET_ITEMS, Item.class)
				.getResultList();
	}

}
