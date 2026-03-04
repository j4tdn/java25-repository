package sorting.bubble;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import bean.Item;
import functional.ItemComp;

import static utils.PrintUtils.*;

public class Ex04BubbleSortItem {
	
	/*
	 Sắp xếp mảng đối tượng, giá trị của từng phần tử có thể tồn tại hoặc là NULL
	 Nếu không xử lý cho giá trị NULL --> NPE khi so sánh để hoán vị
	 
	 Xử lý
	 -----
	 B1: Xử lý cho các phần tử NULL
	     --> NULL first/last
	 
	 B2: Xử lý cho các phần tử còn lại (!NULL)
	     --> *** Tăng/giảm dần *** ==> theo thuộc tính(1 || N) nào
	     --> *** Giá trị của thuộc tính cũng có thể bị NULL
	             2.1 NULL first/last
	             2.2 Xử lý các đối tượng có giá trị thuộc tính != null
	 */
	
	// String: So sánh giá trị của đối tượng rồi hoán vị đối tượng
	// Item:   So sánh giá trị thuộc tính của đối tượng rồi hoán vị đối tượng 
	
	public static void main(String[] args) {
		Item[] items = mockData();
		
		sort(items, (item1, item2) -> {
			return item1.getSalesPrice().compareTo(item2.getSalesPrice());
		});
		generate("1. Sắp xếp tăng dần theo giá bán", items);
		
		sort(items, (item1, item2) -> {
			return item2.getName().compareTo(item1.getName());
		});
		generate("2. Sắp xếp giảm dần theo tên mặt hàng", items);
		
		sort(items, (item1, item2) -> {
			return item1.getExpireDate().compareTo(item2.getExpireDate());
		});
		generate("3. Sắp xếp ngày hết hạn tăng dần", items);
		
		sort(items, (item1, item2) -> {
			int storeIdInt = item2.getStoreId().compareTo(item1.getStoreId());
			if (storeIdInt != 0) {
				return storeIdInt;
			}
			return item1.getSalesPrice().compareTo(item2.getSalesPrice());
		});
		generate("4. Sắp xếp mã cửa hàng giảm dần, giá bán tăng dần", items);
		
		sort(items, (item1, item2) -> {
			int storeIdInt = item1.getStoreId().compareTo(item2.getStoreId());
			if (storeIdInt != 0) {
				return storeIdInt;
			}
			int expriedDateInt = item2.getExpireDate().compareTo(item1.getExpireDate());
			if (expriedDateInt != 0) {
				return expriedDateInt;
			}
			return item2.getId().compareTo(item1.getId());
		});
		generate("5. Sắp xếp mã cửa hàng tăng dần, ngày hết hạn giảm dần, giảm dần theo mã mặt hàng", items);
		
		//    NULL cho Item
		//    NULL cho Item's attribute(s)
		
		items[2] = null; items[6] = null;
		items[5].setSalesPrice(null); items[7].setSalesPrice(null); // item52, item71
		
		sort(items, (item1, item2) -> {
			// B1. NULL first
			if (item1 == null) {
				return -1;
			}
			if (item2 == null) {
				return 1;
			}
			
			// B2: Giảm dần theo mã cửa hàng, tăng dần theo giá bán(NULL last)
			
			// 2.1 Mã Cửa Hàng
			int storeIdInt = item2.getStoreId().compareTo(item1.getStoreId());
			if (storeIdInt != 0) {
				return storeIdInt;
			}
			
			// 2.2 Giá bán
			BigDecimal sp1 = item1.getSalesPrice();
			BigDecimal sp2 = item2.getSalesPrice();
			if (sp1 == null && sp2 != null) {
				return 1;
			}
			if (sp2 == null) {
				return -1;
			}
			return sp1.compareTo(sp2);
		});
		generate("6. Xử lý trường hợp giá trị NULL", items);
		
	}
	
	
	private static Item[] mockData() {
		return new Item[] {
			new Item(1, "Item X1", bd("120"), toDate("10/12/2020"), 101),
			new Item(2, "Item A2", bd("181"), toDate("12/12/2022"), 101),
			new Item(3, "Item Z3", bd("111"), toDate("14/12/2021"), 101),
			new Item(4, "Item B4", bd("888"), toDate("16/12/2023"), 101),
			new Item(51, "Item K2", bd("123"), toDate("16/12/2023"), 105),
			new Item(52, "Item K1", bd("456"), toDate("16/12/2025"), 105),
			new Item(52, "Item K1", bd("789"), toDate("16/12/2024"), 105),
			new Item(71, "Item T9", bd("777"), toDate("16/12/2024"), 107),
			new Item(73, "Item T8", bd("222"), toDate("16/12/2024"), 107),
			new Item(72, "Item T7", bd("555"), toDate("16/12/2024"), 107)
		};
	}
	
	private static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
	
	private static LocalDate toDate(String dMy) {
		return LocalDate.parse(dMy, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	private static void sort(Item[] items, ItemComp itemComp) {
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - i - 1; j++) {
				if (itemComp.compare(items[j], items[j+1]) > 0) {
					swap(items, j, j+1);
				}
			}
		}
	}
	
	private static void swap(Item[] elements, int i, int j) {
		Item temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
}
