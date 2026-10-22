package view;

import java.sql.Date;

import service.ItemService;
import service.ItemServiceImpl;
import static utils.PrintUtils.generate;

public class Ex04Exercises {

	private static final ItemService itemService = new ItemServiceImpl();

	public static void main(String[] args) {
		String p1 = "Giày";
		Date p2 = Date.valueOf("2026-04-10");

		generate(
			"7. Items in group " + p1 + " and not sold on " + p2,
			itemService.getByItemGroupNameAndNotSoldDate(p1, p2)
		);
	}

}
