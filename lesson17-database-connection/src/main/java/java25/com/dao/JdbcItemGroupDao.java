package java25.com.dao;

import java25.com.common.Status;
import java25.com.connection.DbConnection;
import java25.com.persistence.Item;
import java25.com.persistence.ItemGroup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcItemGroupDao implements ItemGroupDao {
    private static String Q_GET_ALL = "SELECT * FROM T02_ITEM_GROUP;";

    @Override
    public List<ItemGroup> findAll() {
        List<ItemGroup> results = new ArrayList<>();

        Connection conn = DbConnection.getConnection();
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
}
