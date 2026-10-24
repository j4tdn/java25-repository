package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import enumeration.Color;
import enumeration.Status;
import persistence.Item;
import persistence.ItemGroup;
import utils.SqlUtils;

public class JdbcItemDao extends GenericDao implements ItemDao {
	
	private static final String Q_GET_ITEMS = ""
			+ "SELECT *\n"
			+ "  FROM t01_item t01\n"
			+ "  JOIN t02_item_group t02\n"
			+ "    ON t02.C02_ITEM_GROUP_ID = t01.C01_ITEM_GROUP_ID";
	
	private static final String Q_GET_ITEMS_BY_GROUP_AND_NOT_SELL_IN_GIVEN_DATE = ""
			+ "SELECT t1.*\n"
			+ "  FROM T01_ITEM t1\n"
			+ "  JOIN T02_ITEM_GROUP t2 ON t1.C01_ITEM_GROUP_ID = t2.C02_ITEM_GROUP_ID\n"
			+ " WHERE t2.C02_ITEM_GROUP_NAME = ?\n"
			+ "   AND NOT EXISTS (\n"
			+ "       SELECT 1\n"
			+ "       FROM T14_ITEM_DETAIL t14\n"
			+ "       INNER JOIN T16_ORDER_DETAIL t16 ON t14.C14_ITEM_DETAIL_ID = t16.C16_ITEM_DETAIL_ID\n"
			+ "       INNER JOIN T06_ORDER t6 ON t16.C16_ORDER_ID = t6.C06_ORDER_ID\n"
			+ "       WHERE DATE(t6.C06_ORDER_DATE) = ?\n"
			+ "         AND t14.C14_ITEM_ID = t1.C01_ITEM_ID\n"
			+ "   )";
	
	@Override
	public List<Item> getItems() {
		return getList(Q_GET_ITEMS, JdbcItemDao::itemIncludeGroupTransformer);
	}
	
	@Override
	public List<Item> getItemsByGroupAndSalesDate(String groupName, LocalDate salesDate) {
		return getList(
			Q_GET_ITEMS_BY_GROUP_AND_NOT_SELL_IN_GIVEN_DATE, pst -> {
				try {
					pst.setString(1, groupName);
					pst.setDate(2, SqlUtils.toDate(salesDate));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			},
			JdbcItemDao::itemTransformer
		);
	}
	
	public static Item itemTransformer(ResultSet rs) {
		Item item = null;
		try {
			item = new Item(
				rs.getLong("C01_ITEM_ID"),
				rs.getString("C01_ITEM_NAME"),
				rs.getBigDecimal("C01_BUY_PRICE"),
				rs.getString("C01_MATERIAL"),
				Color.getName(rs.getString("C01_COLOR"))
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public static Item itemIncludeGroupTransformer(ResultSet rs) {
		Item item = null;
		try {
			ItemGroup group = new ItemGroup(
					rs.getLong("C02_ITEM_GROUP_ID"), 
					rs.getString("C02_ITEM_GROUP_NAME"),
					Status.getName(rs.getInt("C02_STATUS"))
				);
				
			item = new Item(
				rs.getLong("C01_ITEM_ID"),
				rs.getString("C01_ITEM_NAME"),
				rs.getBigDecimal("C01_BUY_PRICE"),
				rs.getString("C01_MATERIAL"),
				Color.getName(rs.getString("C01_COLOR")),
				group
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	
}
