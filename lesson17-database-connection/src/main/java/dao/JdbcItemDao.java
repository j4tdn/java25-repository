package dao;

import connection.DbConnection;
import enumeration.Color;
import enumeration.Status;
import persistence.Item;
import persistence.ItemGroup;
import utils.SqlUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcItemDao implements ItemDao {

    private static final String Q_GET_ITEMS =
            "SELECT t01.*, t02.C02_ITEM_GROUP_ID, " +
            "t02.C02_ITEM_GROUP_NAME, t02.C02_STATUS " +
            "FROM T01_ITEM t01 " +
            "JOIN T02_ITEM_GROUP t02 " +
            "ON t01.C01_ITEM_GROUP_ID = t02.C02_ITEM_GROUP_ID";

    private static final String Q_GET_ITEMS_NOT_SOLD_ON_DATE =
            "SELECT DISTINCT t01.*, t02.C02_ITEM_GROUP_ID, " +
            "t02.C02_ITEM_GROUP_NAME, t02.C02_STATUS " +
            "FROM T01_ITEM t01 " +
            "JOIN T02_ITEM_GROUP t02 " +
            "ON t01.C01_ITEM_GROUP_ID = t02.C02_ITEM_GROUP_ID " +
            "WHERE t02.C02_ITEM_GROUP_NAME = ? " +
            "AND t01.C01_ITEM_ID NOT IN (" +
            " SELECT DISTINCT t14.C14_ITEM_ID " +
            " FROM T14_ITEM_DETAIL t14 " +
            " JOIN T16_ORDER_DETAIL t16 " +
            " ON t14.C14_ITEM_DETAIL_ID = t16.C16_ITEM_DETAIL_ID " +
            " JOIN T15_ORDER t15 " +
            " ON t16.C16_ORDER_ID = t15.C15_ORDER_ID " +
            " WHERE DATE(t15.C15_ORDER_DATE) = ?" +
            ")";

    private final Connection conn;

    public JdbcItemDao() {
        conn = DbConnection.getConnection();
    }

    @Override
    public List<Item> getItems() {
        List<Item> results = new ArrayList<>();

        if (conn == null) {
            return results;
        }

        try (PreparedStatement pst = conn.prepareStatement(Q_GET_ITEMS);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Item item = new Item(
                        rs.getLong("C01_ITEM_ID"),
                        rs.getString("C01_ITEM_NAME"),
                        rs.getBigDecimal("C01_BUY_PRICE"),
                        rs.getString("C01_MATERIAL"),
                        Color.getName(rs.getString("C01_COLOR"))
                );
                results.add(item);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return results;
    }

    @Override
    public List<Item> getItemsByGroupAndNotSoldOnDate(
            String groupName, LocalDate orderDate) {

        List<Item> results = new ArrayList<>();

        if (conn == null) {
            return results;
        }

        String sql = Q_GET_ITEMS_NOT_SOLD_ON_DATE;

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, groupName);
            pst.setDate(2, Date.valueOf(orderDate));

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item(
                            rs.getLong("C01_ITEM_ID"),
                            rs.getString("C01_ITEM_NAME"),
                            rs.getBigDecimal("C01_BUY_PRICE"),
                            rs.getString("C01_MATERIAL"),
                            Color.getName(rs.getString("C01_COLOR"))
                    );
                    results.add(item);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return results;
    }
}
