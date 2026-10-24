package java25.com.dao;

import java25.com.common.Color;
import java25.com.common.Status;
import java25.com.connection.DbConnection;
import java25.com.dto.ItemJoinItemGroup;
import java25.com.persistence.Item;
import java25.com.persistence.ItemGroup;
import java25.com.utils.SqlUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcItemDao implements ItemDao {

    private static String Q_GET_ITEMS = "SELECT * FROM \n" +
            "T01_ITEM t01 JOIN T02_ITEM_GROUP t02\n" +
            "ON t01.C01_ITEM_GROUP_ID = t02.C02_ITEM_GROUP_ID;";

    private static final String Q_GET_ITEMS_NOT_SOLD_ON_DATE =
            "SELECT DISTINCT t01.*, t02.* FROM T01_ITEM t01 " +
                    "JOIN T02_ITEM_GROUP t02 ON t01.C01_ITEM_GROUP_ID = t02.C02_ITEM_GROUP_ID " +
                    "WHERE t02.C02_ITEM_GROUP_NAME = ? " +
                    "AND t01.C01_ITEM_ID NOT IN (" +
                    "    SELECT DISTINCT t14.C14_ITEM_ID " +
                    "    FROM T14_ITEM_DETAIL t14 " +
                    "    JOIN T16_ORDER_DETAIL t16 ON t14.C14_ITEM_DETAIL_ID = t16.C16_ITEM_DETAIL_ID " +
                    "    JOIN T15_ORDER t15 ON t16.C16_ORDER_ID = t15.C15_ORDER_ID " +
                    "    WHERE DATE(t15.C15_ORDER_DATE) = ?" +
                    ")";

    private final Connection conn;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public JdbcItemDao() {
        conn = DbConnection.getConnection();
    }

    @Override
    public List<Item> getItems() {
        List<Item> results = new ArrayList<>();
        try {
            pst = conn.prepareStatement(Q_GET_ITEMS);
            rs = pst.executeQuery();
            while(rs.next()) {
                ItemGroup itemGroup = new ItemGroup(
                        rs.getLong("C02_ITEM_GROUP_ID"),
                        rs.getString("C02_ITEM_GROUP_NAME"),
                        Status.getName(rs.getInt("C02_STATUS"))
                );

                Item item = new Item(
                        rs.getLong("C01_ITEM_ID"),
                        rs.getString("C01_ITEM_NAME"),
                        rs.getBigDecimal("C01_BUY_PRICE"),
                        rs.getString("C01_MATERIAL"),
                        Color.getName(rs.getString("C01_COLOR")),
                        itemGroup
                );

                results.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }
        return results;
    }

    @Override
    public List<Item> getItemsByGroupAndNotSoldOnDate(String groupName, LocalDate orderDate) {
        List<Item> results = new ArrayList<>();
        try {
            pst = conn.prepareStatement(Q_GET_ITEMS_NOT_SOLD_ON_DATE);
            pst.setString(1, groupName);
            pst.setDate(2, Date.valueOf(orderDate));

            rs = pst.executeQuery();
            while (rs.next()) {
                ItemGroup itemGroup = new ItemGroup(
                        rs.getLong("C02_ITEM_GROUP_ID"),
                        rs.getString("C02_ITEM_GROUP_NAME"),
                        Status.getName(rs.getInt("C02_STATUS"))
                );

                Item item = new Item(
                        rs.getLong("C01_ITEM_ID"),
                        rs.getString("C01_ITEM_NAME"),
                        rs.getBigDecimal("C01_BUY_PRICE"),
                        rs.getString("C01_MATERIAL"),
                        Color.getName(rs.getString("C01_COLOR")),
                        itemGroup
                );

                results.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }
        return results;
    }
}
