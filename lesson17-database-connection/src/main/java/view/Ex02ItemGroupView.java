package view;

import static utils.PrintUtils.generate;

import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class Ex02ItemGroupView {
	
	private static ItemGroupService itemGroupService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
	}
	
	public static void main(String[] args) {
		generate(
			"1. Liệt kê tất cả các loại hàng trong hệ thống", 
			itemGroupService.findAll()
		);
		
		generate(
			"2. Liệt kê loại hàng theo mã loại", 
			itemGroupService.findById(6L)
		);
		
		String textSearch = "Giày";
		
		generate(
			"3. Liệt kê loại hàng theo tên loại", 
			itemGroupService.findByName(textSearch)
		);
		
		generate(
			"4. Liệt kê tất cả các loại hàng kèm thông tin mặt hàng", 
			itemGroupService.getItemGroups(),
			ItemGroup::getItems
		);
	}
	
}
