package com.java25.dao;

import com.java25.connection.DbConnection;
import com.java25.persistence.ItemGroup;
import org.hibernate.type.StandardBasicTypes;

import java.util.List;

public class HibernateItemGroupDao extends GenericDao implements ItemGroupDao {
    private static String Q_GET_ALL = ""
//            + "SELECT *\n"
            + "SELECT ig FROM ItemGroup ig";

    private static String Q_GET_BY_NAME = "SELECT * FROM T02_ITEM_GROUP " +
            "WHERE C02_ITEM_GROUP_NAME = :pigName";

    @Override
    public List<ItemGroup> getAll() {
        return openSession()
                .createQuery(Q_GET_ALL, ItemGroup.class)
                .getResultList();
    }

    @Override
    public ItemGroup get(Long id) {
        // Support entity truy van theo id
        return openSession()
                .find(ItemGroup.class, id);
    }

    @Override
    public ItemGroup get(String name) {
        return openSession()
                .createNativeQuery(Q_GET_BY_NAME, ItemGroup.class)
                .setParameter("pigName", name, StandardBasicTypes.STRING)
                .uniqueResult();
    }
}
