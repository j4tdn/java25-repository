package java25.com.dao;

import java25.com.common.Color;
import java25.com.common.Status;
import java25.com.persistence.Item;
import java25.com.persistence.ItemGroup;
import java25.com.utils.SqlUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcItemDao extends GenericDao implements ItemDao {

    private static String Q_GET_ITEMS = "SELECT * FROM \n" +
            "T01_ITEM t01 JOIN T02_ITEM_GROUP t02\n" +
            "ON t01.C01_ITEM_GROUP_ID = t02.C02_ITEM_GROUP_ID;";

    private static final String Q_GET_ITEMS_NOT_SOLD_ON_DATE =
            "SELECT t1.*\n" +
                    "FROM T01_ITEM t1\n" +
                    " JOIN T02_ITEM_GROUP t2 ON t1.C01_ITEM_GROUP_ID = t2.C02_ITEM_GROUP_ID\n" +
                    "WHERE t2.C02_ITEM_GROUP_NAME = ?\n" +
                    "  AND NOT EXISTS (\n" +
                    "      SELECT 1\n" +
                    "      FROM T14_ITEM_DETAIL t14\n" +
                    "       JOIN T16_ORDER_DETAIL t16 ON t14.C14_ITEM_DETAIL_ID = t16.C16_ITEM_DETAIL_ID\n" +
                    "       JOIN T06_ORDER t6 ON t16.C16_ORDER_ID = t6.C06_ORDER_ID\n" +
                    "      WHERE DATE(t6.C06_ORDER_DATE) = ?\n" +
                    "        AND \n" +
                    "        t14.C14_ITEM_ID = t1.C01_ITEM_ID\n" +
                    "  );";


    @Override
    public List<Item> getItems() {
        return getList(Q_GET_ITEMS, JdbcItemDao::itemIncludeGroupTransformer);
    }

    @Override
    public List<Item> getItemsByGroupAndNotSoldOnDate(String groupName, LocalDate salesDate) {
        return getList(Q_GET_ITEMS_NOT_SOLD_ON_DATE, pst -> {
            try {
                pst.setString(1, groupName);
                pst.setDate(2, SqlUtils.toDate(salesDate));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }, JdbcItemDao::itemTransformer);
    }

    public static Item itemTransformer(ResultSet rs) {
        Item item = null;
        try {

            item = new Item(
                    rs.getLong("C01_ITEM_ID"),
                    rs.getString("C01_ITEM_NAME"),
                    rs.getBigDecimal("C01_BUY_PRICE"),
                    rs.getString("C01_MATERIAL"),
                    Color.getName(rs.getString("C01_COLOR"))
            );
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return item;
    }

    public static Item itemIncludeGroupTransformer(ResultSet rs) {
        Item item = null;
        ItemGroup itemGroup = null;
        try {
            itemGroup = new ItemGroup(
                    rs.getLong("C02_ITEM_GROUP_ID"),
                    rs.getString("C02_ITEM_GROUP_NAME"),
                    Status.getName(rs.getInt("C02_STATUS"))
            );

            item = new Item(
                    rs.getLong("C01_ITEM_ID"),
                    rs.getString("C01_ITEM_NAME"),
                    rs.getBigDecimal("C01_BUY_PRICE"),
                    rs.getString("C01_MATERIAL"),
                    Color.getName(rs.getString("C01_COLOR")),
                    itemGroup
            );
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return item;
    }
}
