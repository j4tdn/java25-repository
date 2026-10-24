package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import connection.DbConnection;
import utils.SqlUtils;

class GenericDao {
	
	final Connection conn;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	GenericDao() {
		conn = DbConnection.getConnection();
	}
	
	<E> List<E> getList(String sql, Function<ResultSet, E> getRecordFunc) {
		List<E> result = new ArrayList<>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				E element = getRecordFunc.apply(rs);
				result.add(element);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst, st);
		}
		return result;
	}
	
	<E> List<E> getList(String sql, Consumer<PreparedStatement> paramSetters, Function<ResultSet, E> getRecordFunc) {
		List<E> result = new ArrayList<>();
		try {
			pst = conn.prepareStatement(sql);
			paramSetters.accept(pst);
			rs = pst.executeQuery();
			while(rs.next()) {
				E element = getRecordFunc.apply(rs);
				result.add(element);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst, st);
		}
		return result;
	}
	
	<E> E get(String sql, Consumer<PreparedStatement> paramSetters, Function<ResultSet, E> getRecordFunc) {
		E result = null;
		
		try {
			pst = conn.prepareStatement(sql);
			paramSetters.accept(pst);
			rs = pst.executeQuery();
			if(rs.next()) {
				result = getRecordFunc.apply(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
}
