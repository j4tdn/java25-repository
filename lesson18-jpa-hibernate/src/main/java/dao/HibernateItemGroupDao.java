package dao;

import java.util.List;

import connection.DbConnection;
import persistence.ItemGroup;

public class HibernateItemGroupDao implements ItemGroupDao {
	
	private static String Q_GET_ALL = ""
			+ "SELECT * FROM t02_item_group";
	
	@Override
	public List<ItemGroup> getAll() {
		return DbConnection.getSessionFactory().openSession()
				.createNativeQuery(Q_GET_ALL, ItemGroup.class)
				.getResultList();
	}
}
