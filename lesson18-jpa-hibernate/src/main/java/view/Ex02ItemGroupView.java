package view;

import static utils.PrintUtils.generate;

import java.util.List;

import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class Ex02ItemGroupView {
	
	private static ItemGroupService itemGroupService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
	}
	
	public static void main(String[] args) {
		final List<ItemGroup> groups = itemGroupService.getAll();
		generate(
			"1. Liệt kê tất cả các loại hàng trong hệ thống", 
			groups
		);
		final ItemGroup group1 = groups.get(1);
		generate(
			"1#. Mặt hàng của loại hàng 'group1'", 
			group1.getItems()
		);
		
		generate(
			"2. Liệt kê loại hàng theo mã loại", 
			itemGroupService.get(6)
		);
		
		generate(
			"3. Liệt kê loại hàng theo tên loại", 
			itemGroupService.get("Giày")
		);
	}
	
}
