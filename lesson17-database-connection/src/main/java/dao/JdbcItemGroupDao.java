package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.DbConnection;
import enumeration.Status;
import persistence.ItemGroup;
import utils.SqlUtils;

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
            "HAVING COUNT(*) > ?\n" +
            "ORDER BY AMOUNT_OF_ITEMS DESC, t02.C02_ITEM_GROUP_ID;";

    private static final String Q_INSERT_GROUP =
            "INSERT INTO T02_ITEM_GROUP (C02_ITEM_GROUP_NAME, C02_STATUS) VALUES (?, ?)";
    private static final String Q_INSERT_GROUP_WITH_ID =
            "INSERT INTO T02_ITEM_GROUP (C02_ITEM_GROUP_ID, C02_ITEM_GROUP_NAME, C02_STATUS) " +
            "VALUES (?, ?, ?)";
    private static final String Q_UPDATE_GROUP =
            "UPDATE T02_ITEM_GROUP SET C02_ITEM_GROUP_NAME = ?, C02_STATUS = ? " +
            "WHERE C02_ITEM_GROUP_ID = ?";
    private static final String Q_GROUP_EXISTS =
            "SELECT 1 FROM T02_ITEM_GROUP WHERE C02_ITEM_GROUP_ID = ?";

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
        } finally {
            SqlUtils.close(rs, st);
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

    @Override
    public ItemGroup create(ItemGroup group) throws SQLException {
        boolean withId = group.getId() != null;
        String sql = withId ? Q_INSERT_GROUP_WITH_ID : Q_INSERT_GROUP;
        try (PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            int parameter = 1;
            if (withId) {
                statement.setLong(parameter++, group.getId());
            }
            statement.setString(parameter++, group.getName());
            statement.setInt(parameter, group.getStatus().getValue());
            statement.executeUpdate();

            if (!withId) {
                try (ResultSet keys = statement.getGeneratedKeys()) {
                    if (keys.next()) {
                        group.setId(keys.getLong(1));
                    }
                }
            }
        }
        return group;
    }

    @Override
    public boolean update(ItemGroup group) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(Q_UPDATE_GROUP)) {
            statement.setString(1, group.getName());
            statement.setInt(2, group.getStatus().getValue());
            statement.setLong(3, group.getId());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        }
        // MySQL may report 0 if the new values match the existing values.
        return existsById(group.getId());
    }

    @Override
    public ItemGroup save(ItemGroup group) throws SQLException {
        if (group.getId() == null) {
            return create(group);
        }
        if (existsById(group.getId())) {
            update(group);
            return group;
        }
        return create(group);
    }

    private boolean existsById(long id) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(Q_GROUP_EXISTS)) {
            statement.setLong(1, id);
            try (ResultSet row = statement.executeQuery()) {
                return row.next();
            }
        }
    }

    @Override
    public int createMany(List<ItemGroup> groups) throws SQLException {
        if (groups == null || groups.isEmpty()) {
            return 0;
        }
        if (!conn.getAutoCommit()) {
            throw new SQLException("Không thể thêm hàng loạt khi có giao dịch khác đang mở.");
        }
        boolean withIds = groups.get(0).getId() != null;
        for (ItemGroup group : groups) {
            if ((group.getId() != null) != withIds) {
                throw new IllegalArgumentException("Các loại hàng phải cùng có mã hoặc cùng tự sinh mã.");
            }
        }
        try {
            conn.setAutoCommit(false);
            try (PreparedStatement statement = conn.prepareStatement(
                    withIds ? Q_INSERT_GROUP_WITH_ID : Q_INSERT_GROUP)) {
                for (ItemGroup group : groups) {
                    int parameter = 1;
                    if (withIds) {
                        statement.setLong(parameter++, group.getId());
                    }
                    statement.setString(parameter++, group.getName());
                    statement.setInt(parameter, group.getStatus().getValue());
                    statement.addBatch();
                }
                statement.executeBatch();
            }
            conn.commit();
            return groups.size();
        } catch (SQLException | RuntimeException ex) {
            try {
                conn.rollback();
            } catch (SQLException rollbackError) {
                ex.addSuppressed(rollbackError);
            }
            throw ex;
        } finally {
            conn.setAutoCommit(true);
        }
    }

}
