package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DbConnection;
import enumeration.Color;
import persistence.Item;
import utils.SqlUtils;

public class JdbcItemDao implements ItemDao {

	private static final String Q_GET_BY_ITEM_GROUP_NAME_AND_NOT_SOLD_DATE = ""
			+ "SELECT DISTINCT t01.*\n"
			+ "  FROM t01_item t01\n"
			+ "  JOIN t02_item_group t02\n"
			+ "    ON t02.C02_ITEM_GROUP_ID = t01.C01_ITEM_GROUP_ID\n"
			+ " WHERE t02.C02_ITEM_GROUP_NAME = ?\n"
			+ "   AND NOT EXISTS (\n"
			+ "       SELECT 1\n"
			+ "         FROM t14_item_detail t14\n"
			+ "         JOIN t16_order_detail t16\n"
			+ "           ON t16.C16_ITEM_DETAIL_ID = t14.C14_ITEM_DETAIL_ID\n"
			+ "         JOIN t06_order t06\n"
			+ "           ON t06.C06_ORDER_ID = t16.C16_ORDER_ID\n"
			+ "        WHERE t14.C14_ITEM_ID = t01.C01_ITEM_ID\n"
			+ "          AND DATE(t06.C06_ORDER_DATE) = ?\n"
			+ "   )";

	private final Connection conn;

	public JdbcItemDao() {
		conn = DbConnection.getConnection();
	}

	@Override
	public List<Item> getByItemGroupNameAndNotSoldDate(String itemGroupName, Date saleDate) {
		List<Item> result = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = conn.prepareStatement(Q_GET_BY_ITEM_GROUP_NAME_AND_NOT_SOLD_DATE);
			pst.setString(1, itemGroupName);
			pst.setDate(2, saleDate);
			rs = pst.executeQuery();

			while (rs.next()) {
				result.add(new Item(
					rs.getLong("C01_ITEM_ID"),
					rs.getString("C01_ITEM_NAME"),
					rs.getBigDecimal("C01_BUY_PRICE"),
					rs.getString("C01_MATERIAL"),
					Color.getName(rs.getString("C01_COLOR"))
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}

		return result;
	}

}
