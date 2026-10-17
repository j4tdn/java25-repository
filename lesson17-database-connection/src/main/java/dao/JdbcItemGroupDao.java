package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import connection.DbConnection;
import enumeration.Color;
import enumeration.Status;
import persistence.Item;
import persistence.ItemGroup;
import utils.SqlUtils;

public class JdbcItemGroupDao implements ItemGroupDao {
	
	private static String Q_GET_ALL = ""
			+ "SELECT * FROM t02_item_group";
	
	private static String Q_GET_ITEM_GROUPS = ""
			+ "SELECT *\n"
			+ "  FROM t02_item_group t02\n"
			+ "  JOIN t01_item t01\n"
			+ "    ON t02.C02_ITEM_GROUP_ID = t01.C01_ITEM_GROUP_ID";
	
	private static String Q_GET_ITEM_GROUP_BY_ID = ""
			+ "SELECT *\n"
			+ "  FROM t02_item_group\n"
			+ " WHERE C02_ITEM_GROUP_ID = %s";
	
	// createStatement(...)   => phải là 1 câu SQL hoàn chỉnh
	// preparedStatement(...) => câu SQL có thể chứa param được set giá trị sau
	
	// ? SQL có 1 param là ?, sẽ được truyền giá trị vào khi thực thi
	private static String Q_GET_ITEM_GROUP_BY_NAME = ""
			+ "SELECT *\n"
			+ "  FROM t02_item_group\n"
			+ " WHERE C02_ITEM_GROUP_NAME = ?";
	
	private final Connection conn;
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public JdbcItemGroupDao() {
		conn = DbConnection.getConnection();
	}
	
	@Override
	public List<ItemGroup> getAll() {
		List<ItemGroup> result = new ArrayList<>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(Q_GET_ALL);
			while(rs.next()) {
				ItemGroup group = new ItemGroup(
					rs.getLong("C02_ITEM_GROUP_ID"), 
					rs.getString("C02_ITEM_GROUP_NAME"),
					Status.getName(rs.getInt("C02_STATUS"))
				);
				result.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
	
	@Override
	public List<ItemGroup> getItemGroups() {
		Map<ItemGroup, List<Item>> map = new HashMap<>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(Q_GET_ITEM_GROUPS);
			while(rs.next()) {
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
				
				// DB: ItemGroup, Item
				// JV: ItemGroup, List<Item>
				
				// DB: Item, ItemGroup
				// JV: ItemGroup, List<Item>
				
				if (!map.containsKey(group)) {
					List<Item> items = new ArrayList<>();
					items.add(item);
					map.put(group, items);
				} else {
					List<Item> items = map.get(group);
					items.add(item);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		
		List<ItemGroup> result = map.entrySet().stream()
				.map(e -> new ItemGroup(e.getKey(), e.getValue()))
				.collect(Collectors.toList());
		
		return result;
	}
	
	@Override
	public ItemGroup get(int id) {
		ItemGroup result = null;
		
		String sql = Q_GET_ITEM_GROUP_BY_ID.formatted(id);
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				result = new ItemGroup(
					rs.getLong("C02_ITEM_GROUP_ID"), 
					rs.getString("C02_ITEM_GROUP_NAME"),
					Status.getName(rs.getInt("C02_STATUS"))
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
	
	@Override
	public ItemGroup get(String name) {
		ItemGroup result = null;
		
		try {
			pst = conn.prepareStatement(Q_GET_ITEM_GROUP_BY_NAME);
			pst.setString(1, name);
			rs = pst.executeQuery();
			if(rs.next()) {
				result = new ItemGroup(
					rs.getLong("C02_ITEM_GROUP_ID"), 
					rs.getString("C02_ITEM_GROUP_NAME"),
					Status.getName(rs.getInt("C02_STATUS"))
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		return result;
	}
	
}
