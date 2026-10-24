package java25.com.dao;

import java25.com.common.Status;
import java25.com.connection.DbConnection;
import java25.com.persistence.ItemGroup;
import java25.com.utils.SqlUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcItemGroupDao implements ItemGroupDao {
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

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public JdbcItemGroupDao() {
        conn = DbConnection.getConnection();
    }

    @Override
    public List<ItemGroup> findAll() {
        List<ItemGroup> results = new ArrayList<>();

        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Q_GET_ALL);
            while (rs.next()) {
                ItemGroup group = new ItemGroup(
                        rs.getLong("C02_ITEM_GROUP_ID"),
                        rs.getString("C02_ITEM_GROUP_NAME"),
                        Status.getName(rs.getInt("C02_STATUS"))
                );
                results.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public ItemGroup findById(Long itemGroupId) {
        ItemGroup itemGroup = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(Q_GET_BY_ID);
            pst.setLong(1, itemGroupId);
            rs = pst.executeQuery();
            if (rs.next()) {
                itemGroup = new ItemGroup(
                        rs.getLong("C02_ITEM_GROUP_ID"),
                        rs.getString("C02_ITEM_GROUP_NAME"),
                        Status.getName(rs.getInt("C02_STATUS"))
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }
        return itemGroup;
    }

    @Override
    public ItemGroup findByName(String name) {
        ItemGroup itemGroup = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(Q_GET_BY_NAME);
            pst.setString(1, "%" + name + "%");
            rs = pst.executeQuery();
            if (rs.next()) {
                itemGroup = new ItemGroup(
                        rs.getLong("C02_ITEM_GROUP_ID"),
                        rs.getString("C02_ITEM_GROUP_NAME"),
                        Status.getName(rs.getInt("C02_STATUS"))
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }
        return itemGroup;
    }

    @Override
    public List<ItemGroupDto> countItemsPerGroup(int amount) {
        List<ItemGroupDto> results = new ArrayList<>();
        try {
            pst = conn.prepareStatement(Q_COUNT_ITEMS);
            pst.setInt(1, amount);
            rs = pst.executeQuery();
            while (rs.next()) {
                ItemGroupDto group = new ItemGroupDto(
                        rs.getLong("ITEM_GROUP_ID"),
                        rs.getString("ITEM_GROUP_NAME"),
                        rs.getInt("AMOUNT_OF_ITEMS"));
                results.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }
        return results;
    }


    private static final String Q_INSERT = "INSERT INTO T02_ITEM_GROUP "
            + "(C02_ITEM_GROUP_ID, C02_ITEM_GROUP_NAME, C02_STATUS) VALUES (?, ?, ?)";
    private static final String Q_UPDATE = "UPDATE T02_ITEM_GROUP "
            + "SET C02_ITEM_GROUP_NAME = ?, C02_STATUS = ? WHERE C02_ITEM_GROUP_ID = ?";

    private void bindInsert(PreparedStatement statement, ItemGroup group) throws SQLException {
        statement.setLong(1, group.getId());
        statement.setString(2, group.getName());
        statement.setInt(3, group.getStatus().getValue());
    }

    @Override
    public int insert(ItemGroup group) {
        try (Connection connection = DbConnection.openConnection();
             PreparedStatement statement = connection.prepareStatement(Q_INSERT)) {
            bindInsert(statement, group);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Khong them duoc loai hang. Kiem tra ma da ton tai.", e);
        }
    }

    @Override
    public int update(ItemGroup group) {
        try (Connection connection = DbConnection.openConnection();
             PreparedStatement statement = connection.prepareStatement(Q_UPDATE)) {
            statement.setString(1, group.getName());
            statement.setInt(2, group.getStatus().getValue());
            statement.setLong(3, group.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Khong sua duoc loai hang.", e);
        }
    }

    // Them neu chua co ID; cap nhat neu ID da ton tai (mot lenh nguyen tu).
    @Override
    public int save(ItemGroup group) {
        String sql = Q_INSERT + " ON DUPLICATE KEY UPDATE "
                + "C02_ITEM_GROUP_NAME = ?, C02_STATUS = ?";
        try (Connection connection = DbConnection.openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            bindInsert(statement, group);
            statement.setString(4, group.getName());
            statement.setInt(5, group.getStatus().getValue());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Khong luu duoc loai hang.", e);
        }
    }

    @Override
    public int insertBatch(List<ItemGroup> groups) {
        try (Connection connection = DbConnection.openConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(Q_INSERT)) {
                for (ItemGroup group : groups) {
                    bindInsert(statement, group);
                    statement.addBatch();
                }
                int[] counts = statement.executeBatch();
                if (counts.length != groups.size()) throw new SQLException("Thieu ket qua batch");
                for (int count : counts) {
                    if (count != 1 && count != Statement.SUCCESS_NO_INFO)
                        throw new SQLException("Co dong them khong thanh cong");
                }
                connection.commit();
                return groups.size();
            } catch (SQLException e) {
                try { connection.rollback(); } catch (SQLException rollback) { e.addSuppressed(rollback); }
                throw e;
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Them nhieu loai hang that bai; cac dong chua duoc luu.", e);
        }
    }
}
