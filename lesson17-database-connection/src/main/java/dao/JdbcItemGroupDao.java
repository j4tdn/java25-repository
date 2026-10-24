package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import enumeration.Status;
import persistence.Item;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import utils.SqlUtils;

public class JdbcItemGroupDao extends GenericDao implements ItemGroupDao {
	
	private static String Q_GET_ALL = ""
			+ "SELECT * FROM t02_item_group";
	
	private static String Q_GET_ITEM_GROUPS = ""
			+ "SELECT *\n"
			+ "  FROM t02_item_group t02\n"
			+ "  JOIN t01_item t01\n"
			+ "    ON t02.C02_ITEM_GROUP_ID = t01.C01_ITEM_GROUP_ID";
	
	private static final String Q_COUNT_ITEMS_PER_GROUP = ""
			+ "SELECT t02.C02_ITEM_GROUP_ID   ITEM_GROUP_ID,\n"
			+ "       t02.C02_ITEM_GROUP_NAME ITEM_GROUP_NAME,\n"
			+ "       COUNT(*)                AMOUNT_OF_ITEMS\n"
			+ "  FROM t02_item_group t02\n"
			+ "  JOIN t01_item t01\n"
			+ "    ON t02.C02_ITEM_GROUP_ID = t01.C01_ITEM_GROUP_ID\n"
			+ "  GROUP BY t02.C02_ITEM_GROUP_ID";
	
	private static String Q_GET_ITEM_GROUP_BY_ID = ""
			+ "SELECT *\n"
			+ "  FROM t02_item_group\n"
			+ " WHERE C02_ITEM_GROUP_ID = ?";
	
	// createStatement(...)   => phải là 1 câu SQL hoàn chỉnh
	// preparedStatement(...) => câu SQL có thể chứa param được set giá trị sau
	
	// ? SQL có 1 param là ?, sẽ được truyền giá trị vào khi thực thi
	private static String Q_GET_ITEM_GROUP_BY_NAME = ""
			+ "SELECT *\n"
			+ "  FROM t02_item_group\n"
			+ " WHERE C02_ITEM_GROUP_NAME = ?";
	
	@Override
	public List<ItemGroup> getAll() {
		return getList(Q_GET_ALL, JdbcItemGroupDao::groupTransformer);
	}
	
	@Override
	public List<ItemGroup> getItemGroups() {
		Map<ItemGroup, List<Item>> map = new HashMap<>();
		
		try {
			pst = conn.prepareStatement(Q_GET_ITEM_GROUPS);
			rs = pst.executeQuery();
			while(rs.next()) {
				ItemGroup group = groupTransformer(rs);
				Item item = JdbcItemDao.itemTransformer(rs);
				
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
	public List<ItemGroupDto> countItemsPerGroup() {
		return getList(Q_COUNT_ITEMS_PER_GROUP, JdbcItemGroupDao::groupDtoTransformer);
	}
	
	@Override
	public ItemGroup get(int id) {
		return get(
			Q_GET_ITEM_GROUP_BY_ID, 
			pst -> {
				try {
					pst.setInt(1, id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			},
			JdbcItemGroupDao::groupTransformer
	);
	}
	
	@Override
	public ItemGroup get(String name) {
		return get(
			Q_GET_ITEM_GROUP_BY_NAME, 
			pst -> {
				try {
					pst.setString(1, name);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			},
			JdbcItemGroupDao::groupTransformer
		);
	}
	
	public static ItemGroup groupTransformer(ResultSet rs) {
		ItemGroup group = null;
		try {
			group = new ItemGroup(
				rs.getLong("C02_ITEM_GROUP_ID"), 
				rs.getString("C02_ITEM_GROUP_NAME"),
				Status.getName(rs.getInt("C02_STATUS"))
			);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return group;
	}
	
	public static ItemGroupDto groupDtoTransformer(ResultSet rs) {
		ItemGroupDto group = null;
		try {
			group = new ItemGroupDto(
				rs.getLong("ITEM_GROUP_ID"), 
				rs.getString("ITEM_GROUP_NAME"),
				rs.getInt("AMOUNT_OF_ITEMS")
			);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return group;
	}
	
}
