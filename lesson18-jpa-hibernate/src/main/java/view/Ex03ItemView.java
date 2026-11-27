package view;

import service.ItemService;
import service.ItemServiceImpl;

import static utils.PrintUtils.generate;

import java.util.List;

import persistence.Item;

public class Ex03ItemView {

	private static ItemService itemService;

	static {
		itemService = new ItemServiceImpl();
	}

	public static void main(String[] args) {
		final List<Item> items = itemService.getAll();
		generate(
			"4. Liệt kê tất cả các mặt hàng trong hệ thống", 
			items
		);
		
		Item item1 = items.get(1);
		System.out.println("ItemGroup ==> " + item1.getGroup());
	}

}
