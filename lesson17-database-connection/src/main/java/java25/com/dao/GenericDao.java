package java25.com.dao;

import java25.com.connection.DbConnection;
import java25.com.utils.SqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class GenericDao {
    final Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public GenericDao() {
        this.conn = DbConnection.getConnection();
    }

    <E> List<E> getList(String sql, Function<ResultSet, E> getRecordFunc) {
        List<E> results = new ArrayList<>();

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                E element = getRecordFunc.apply(rs);
                results.add(element);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }
        return results;
    }

    <E> E get(String sql, Consumer<PreparedStatement> paramSetters, Function<ResultSet, E> getRecordFunc) {
        E result = null;

        try {
            pst = conn.prepareStatement(sql);
            paramSetters.accept(pst);
            rs = pst.executeQuery();
            if (rs.next()) {
                result = getRecordFunc.apply(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(pst, pst);
        }
        return result;
    }

    <E> List<E> getList(String sql, Consumer<PreparedStatement> paramSetters, Function<ResultSet, E> getRecordFunc) {
        List<E> results = new ArrayList<>();

        try {
            pst = conn.prepareStatement(sql);
            paramSetters.accept(pst);
            rs = pst.executeQuery();
            while (rs.next()) {
                E element = getRecordFunc.apply(rs);
                results.add(element);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(pst, pst);
        }
        return results;
    }

    boolean modify(String sql, Consumer<PreparedStatement> paramSetters) {
        int count = 0;
        try {
            pst = conn.prepareStatement(sql);
            paramSetters.accept(pst);
            count = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(pst);
        }
        return count > 0;
    }
}
