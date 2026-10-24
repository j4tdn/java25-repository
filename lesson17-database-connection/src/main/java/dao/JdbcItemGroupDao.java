package dao;

import connection.DbConnection;
import enumeration.Color;
import enumeration.Status;
import persistence.Item;
import persistence.ItemGroup;
import utils.SqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JdbcItemGroupDao implements ItemGroupDao {

    private static final String Q_GET_ALL =
            "SELECT * FROM T02_ITEM_GROUP";

    private static final String Q_GET_ITEM_GROUPS =
            "SELECT t02.*, t01.* " +
            "FROM T02_ITEM_GROUP t02 " +
            "JOIN T01_ITEM t01 " +
            "ON t02.C02_ITEM_GROUP_ID = t01.C01_ITEM_GROUP_ID";

    private static final String Q_GET_ITEM_GROUP_BY_NAME =
            "SELECT * FROM T02_ITEM_GROUP " +
            "WHERE C02_ITEM_GROUP_NAME = ?";

    private final Connection conn;

    public JdbcItemGroupDao() {
        conn = DbConnection.getConnection();
    }

    @Override
    public List<ItemGroup> getAll() {
        List<ItemGroup> result = new ArrayList<>();

        if (conn == null) {
            return result;
        }

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(Q_GET_ALL)) {

            while (rs.next()) {
                ItemGroup group = new ItemGroup(
                        rs.getLong("C02_ITEM_GROUP_ID"),
                        rs.getString("C02_ITEM_GROUP_NAME"),
                        Status.getName(rs.getInt("C02_STATUS"))
                );
                result.add(group);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<ItemGroup> getItemGroups() {
        Map<ItemGroup, List<Item>> map = new HashMap<>();

        if (conn == null) {
            return new ArrayList<>();
        }

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(Q_GET_ITEM_GROUPS)) {

            while (rs.next()) {
                ItemGroup group = new ItemGroup(
                        rs.getLong("C02_ITEM_GROUP_ID"),
                        rs.getString("C02_ITEM_GROUP_NAME"),
                        Status.getName(rs.getInt("C02_STATUS"))
                );

                Item item = new Item(
                        rs.getLong("C01_ITEM_ID"),
                        rs.getString("C01_ITEM_NAME"),
                        rs.getBigDecimal("C01_BUY_PRICE"),
                        rs.getString("C01_MATERIAL"),
                        Color.getName(rs.getString("C01_COLOR"))
                );

                if (!map.containsKey(group)) {
                    List<Item> items = new ArrayList<>();
                    items.add(item);
                    map.put(group, items);
                } else {
                    map.get(group).add(item);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map.entrySet().stream()
                .map(e -> new ItemGroup(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public ItemGroup get(int id) {
        ItemGroup result = null;
        String sql = "SELECT * FROM T02_ITEM_GROUP WHERE C02_ITEM_GROUP_ID = ?";

        if (conn == null) {
            return null;
        }

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    result = new ItemGroup(
                            rs.getLong("C02_ITEM_GROUP_ID"),
                            rs.getString("C02_ITEM_GROUP_NAME"),
                            Status.getName(rs.getInt("C02_STATUS"))
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public ItemGroup get(String name) {
        ItemGroup result = null;

        if (conn == null) {
            return null;
        }

        try (PreparedStatement pst = conn.prepareStatement(Q_GET_ITEM_GROUP_BY_NAME)) {
            pst.setString(1, name);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    result = new ItemGroup(
                            rs.getLong("C02_ITEM_GROUP_ID"),
                            rs.getString("C02_ITEM_GROUP_NAME"),
                            Status.getName(rs.getInt("C02_STATUS"))
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean add(ItemGroup itemGroup) {
        String sql = "INSERT INTO T02_ITEM_GROUP " +
                "(C02_ITEM_GROUP_NAME, C02_STATUS) VALUES (?, ?)";

        if (conn == null) {
            return false;
        }

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, itemGroup.getName());
            pst.setInt(2, itemGroup.getStatus().getValue());
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(ItemGroup itemGroup) {
        String sql = "UPDATE T02_ITEM_GROUP " +
                "SET C02_ITEM_GROUP_NAME = ?, C02_STATUS = ? " +
                "WHERE C02_ITEM_GROUP_ID = ?";

        if (conn == null) {
            return false;
        }

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, itemGroup.getName());
            pst.setInt(2, itemGroup.getStatus().getValue());
            pst.setLong(3, itemGroup.getId());
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public int addAll(List<ItemGroup> itemGroups) {
        String sql = "INSERT INTO T02_ITEM_GROUP " +
                "(C02_ITEM_GROUP_NAME, C02_STATUS) VALUES (?, ?)";
        int count = 0;

        if (conn == null || itemGroups == null || itemGroups.isEmpty()) {
            return 0;
        }

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            for (ItemGroup itemGroup : itemGroups) {
                pst.setString(1, itemGroup.getName());
                pst.setInt(2, itemGroup.getStatus().getValue());
                pst.addBatch();
            }

            int[] results = pst.executeBatch();
            for (int result : results) {
                if (result > 0 || result == Statement.SUCCESS_NO_INFO) {
                    count++;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
}
