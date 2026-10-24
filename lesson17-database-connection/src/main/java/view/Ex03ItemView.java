package view;

import static utils.PrintUtils.generate;

import java.time.LocalDate;
import java.time.Month;

import service.ItemService;
import service.ItemServiceImpl;

public class Ex03ItemView {
	
	private static ItemService itemService;
	
	static {
		itemService = new ItemServiceImpl();
	}
	
	public static void main(String[] args) {
		generate(
			"5. Liệt kê tất cả các mặt hàng kèm thông tin loại hàng", 
			itemService.getItems()
		);
		
		generate(
			"7. Liệt kê những 'mặt hàng' thuộc loại hàng là @p1 và không bán được trong ngày @p2", 
			itemService.getItemsByGroupAndSalesDate("Áo", LocalDate.of(2026, Month.APRIL, 20))
		);
	}
	
}
