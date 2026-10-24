package view;

import static utils.PrintUtils.generate;

import service.ItemService;
import service.ItemServiceImpl;

public class Ex03ItemView {

	private static final ItemService itemService = new ItemServiceImpl();

	public static void main(String[] args) {
		generate(
			"4. List all items with their item group",
			itemService.getItems()
		);
	}
}
