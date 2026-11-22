package view;

import static utils.PrintUtils.generate;

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
			itemGroupService.getAll()
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
