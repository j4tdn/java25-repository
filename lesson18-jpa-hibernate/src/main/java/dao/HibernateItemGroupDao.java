package dao;

import java.util.List;

import org.hibernate.type.StandardBasicTypes;

import persistence.ItemGroup;

public class HibernateItemGroupDao extends GenericDao implements ItemGroupDao {

	// native query | java persistence query language
	
	// createNativeQuery | createQuery
	
	// createNamedQuery ==> pass name(from Entity) of the query(native/jpql) instead of real query
	
	private static String Q_GET_ALL = "" 
			+ "SELECT * FROM t02_item_group";
	
	private static String Q_GET_ITEM_GROUP_BY_NAME = ""
			+ "SELECT *\n"
			+ "  FROM t02_item_group\n"
			+ " WHERE C02_ITEM_GROUP_NAME = :p_igname";

	@Override
	public List<ItemGroup> getAll() {
		return openSession()
				.createNativeQuery(Q_GET_ALL, ItemGroup.class)
				.getResultList();
	}
	
	@Override
	public ItemGroup get(long id) {
		return openSession().find(ItemGroup.class, id);
	}
	
	@Override
	public ItemGroup get(String name) {
		return openSession().createNativeQuery(Q_GET_ITEM_GROUP_BY_NAME, ItemGroup.class)
				.setParameter("p_igname", name, StandardBasicTypes.STRING)
				.uniqueResult();
	}
	
}
