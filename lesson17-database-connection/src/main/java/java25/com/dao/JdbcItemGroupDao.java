package java25.com.dao;

import java25.com.common.Status;
import java25.com.connection.DbConnection;
import java25.com.persistence.ItemGroup;

import java.sql.*;
import java.util.List;

public class JdbcItemGroupDao extends GenericDao implements ItemGroupDao {
    private static String Q_GET_ALL = "SELECT * FROM T02_ITEM_GROUP;";
    private static String Q_GET_BY_ID = "SELECT * FROM T02_ITEM_GROUP " +
            "WHERE C02_ITEM_GROUP_ID = ?;";
    private static String Q_GET_BY_NAME = "SELECT * FROM T02_ITEM_GROUP " +
            "WHERE C02_ITEM_GROUP_NAME LIKE ?;";
    private static String Q_JOIN_ITEM = "SELECT * FROM \n" +
            "T01_ITEM t01 JOIN T02_ITEM_GROUP t02\n" +
            "ON t01.C01_ITEM_GROUP_ID = t02.C02_ITEM_GROUP_ID;";
    private static String Q_COUNT_ITEMS = "" +
            "SELECT t02.C02_ITEM_GROUP_ID   AS ITEM_GROUP_ID,\n" +
            "       t02.C02_ITEM_GROUP_NAME AS ITEM_GROUP_NAME,\n" +
            "       COUNT(*)                AS AMOUNT_OF_ITEMS\n" +
            "FROM T02_ITEM_GROUP t02\n" +
            "JOIN T01_ITEM t01\n" +
            "  ON t02.C02_ITEM_GROUP_ID = t01.C01_ITEM_GROUP_ID\n" +
            "GROUP BY t02.C02_ITEM_GROUP_ID,t02.C02_ITEM_GROUP_NAME\n" +
            "HAVING AMOUNT_OF_ITEMS > ?;";

    private static String Q_INSERT = "" +
            "INSERT INTO T02_ITEM_GROUP (C02_ITEM_GROUP_NAME, C02_STATUS)\n" +
            "VALUES (?, ?);";

    private static String Q_UPDATE = ""+
            "UPDATE T02_ITEM_GROUP\n" +
            "SET C02_ITEM_GROUP_NAME = ?, \n" +
            "    C02_STATUS = ?\n" +
            "WHERE C02_ITEM_GROUP_ID = ?;";

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public JdbcItemGroupDao() {
        conn = DbConnection.getConnection();
    }

    @Override
    public List<ItemGroup> findAll() {
        return getList(Q_GET_ALL, this::groupTransformer);
    }

    @Override
    public ItemGroup findById(Long itemGroupId) {
        return get(Q_GET_BY_ID, pst -> {
                    try {
                        pst.setLong(1, itemGroupId);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                },
                this::groupTransformer);
    }

    @Override
    public ItemGroup findByName(String name) {
        return get(Q_GET_BY_NAME, pst -> {
                    try {
                        pst.setString(2, name);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                },
                this::groupTransformer);
    }

    @Override
    public List<ItemGroupDto> countItemsPerGroup(int amount) {
        return getList(Q_COUNT_ITEMS, this::groupDtoTransformer);
    }

    @Override
    public boolean saveOrUpdate(ItemGroup request) {
        ItemGroup itemGroup = null;
        if(request.getId() != null) {
            return modify(Q_INSERT, pst -> {
                try {
                    pst.setString(1, request.getName());
                    pst.setInt(2, 1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } else {
            return modify(Q_UPDATE, pst -> {
                try {
                    pst.setString(1, request.getName());
                    pst.setInt(2, request.getStatus().getValue());
                    pst.setLong(3, request.getId());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private ItemGroup groupTransformer(ResultSet rs) {
        ItemGroup group = null;
        try {
            group = new ItemGroup(
                    rs.getLong("C02_ITEM_GROUP_ID"),
                    rs.getString("C02_ITEM_GROUP_NAME"),
                    Status.getName(rs.getInt("C02_STATUS"))
            );
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return group;
    }

    private ItemGroupDto groupDtoTransformer(ResultSet rs) {
        ItemGroupDto group = null;
        try {
            group = new ItemGroupDto(
                    rs.getLong("ITEM_GROUP_ID"),
                    rs.getString("ITEM_GROUP_NAME"),
                    rs.getInt("AMOUNT_OF_ITEMS")
            );
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return group;
    }

}
