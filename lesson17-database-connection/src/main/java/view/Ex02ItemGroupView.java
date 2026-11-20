package view;

import static utils.PrintUtils.generate;

import java.util.List;

import enumeration.Status;
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
			itemGroupService.getAll()
		);
		
		generate(
			"2. Liệt kê loại hàng theo mã loại", 
			itemGroupService.get(6)
		);
		
		// sql injection "xyz' OR '1=1"
		String textSearch = "Giày";
		
		generate(
			"3. Liệt kê loại hàng theo tên loại", 
			itemGroupService.get(textSearch)
		);
		
		generate(
			"4. Liệt kê tất cả các loại hàng kèm thông tin mặt hàng", 
			itemGroupService.getItemGroups(),
			ItemGroup::getItems
		);
		
		generate(
			"6. Đếm số lượng mặt hàng của từng loại hàng", 
			itemGroupService.countItemsPerGroup()
		);
		
		System.out.println("8. Thực hiện thêm/sửa loại hàng");
		// itemGroupService.save(new ItemGroup("Balo", Status.Disabled));
		// itemGroupService.saveOrUpdate(new ItemGroup(66L, "Thắt lưng", Status.Active));
		
		System.out.println("9. Thực hiện thêm danh sách loại hàng");
		itemGroupService.save(
			List.of(new ItemGroup("Loại hàng A1 ", Status.Active),
					new ItemGroup("Loại hàng A2 ", Status.Active),
					new ItemGroup("Loại hàng A3 ", Status.Disabled))
		);
	}
	
}
