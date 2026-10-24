package view;

import java.sql.Date;

import service.ItemService;
import service.ItemServiceImpl;
import static utils.PrintUtils.generate;

public class Ex04IGNameNotSoldDateView {

	private static final ItemService itemService = new ItemServiceImpl();

	/*
	Câu 7
	Liệt kê những "mặt hàng":
	- Thuộc loại hàng là @1
	- Và không bán được trong ngày @p2
	Trong đó:
	- @p1 là chuỗi dữ liệu
	- @p2 thông tin dưới dạng ngày tháng năm
	*/

	public static void main(String[] args) {
		String p1 = "Giày";
		Date p2 = Date.valueOf("2026-04-10");

		generate(
			"7. Items in group " + p1 + " and not sold on " + p2,
			itemService.getByItemGroupNameAndNotSoldDate(p1, p2)
		);
	}

}
