package sorting.selection;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import bean.Item;
import functional.ItemComp;
import model.DataModel;

import static utils.PrintUtils.*;
import static utils.ArrayUtils.*;

public class Ex02SelectionSortItem {
	
	/*
	 Sx mảng đối tượng, giá trị của từng phần tử có thể tồn tại hoặc là NULL
	 Nếu k xử lý cho giá trị NULL --> NPE khi so sánh để hoán vị
	 
	 Xử lý
	 -----
	 B1: Xử lý cho các phần tử NULL
	     --> NULL first/last
	 
	 B2: Xử lý cho các phần tử còn lại (!NULL)
	     --> *** Tăng/giảm dần *** ==> theo thuộc tính(1 || N) nào
	     --> *** Gtri của thuộc tính cũng có thể bị NULL
	             2.1 NULL first/last
	             2.2 Xử lý các đối tượng có gtri thuộc tính != null
	 */
	
	// String: Ss gtri của đối tượng rồi hoán vị đối tượng
	// Item:   Ss gtri thuộc tính của đối tượng rồi hoán vị đối tượng 
	
	public static void main(String[] args) {
		System.out.println("== SELECTION SORT ===");
		
		Item[] items = DataModel.mockItems();
		
		sort(items, (item1, item2) -> {
			return item1.getSalesPrice().compareTo(item2.getSalesPrice());
		});
		generate("1. Sx tăng dần theo giá bán", items);
		
		sort(items, (item1, item2) -> {
			return item2.getName().compareTo(item1.getName());
		});
		generate("2. Sx giảm dần theo tên mặt hàng", items);
		
		sort(items, (item1, item2) -> {
			return item1.getExpiredDate().compareTo(item2.getExpiredDate());
		});
		generate("3. Sx ngày hết hạn tăng dần", items);
		
		sort(items, (item1, item2) -> {
			int storeIdInt = item2.getStoreId().compareTo(item1.getStoreId());
			if (storeIdInt != 0) {
				return storeIdInt;
			}
			return item1.getSalesPrice().compareTo(item2.getSalesPrice());
		});
		generate("4. Sx mã cửa hàng giảm dần, giá bán tăng dần", items);
		
		sort(items, (item1, item2) -> {
			int storeIdInt = item1.getStoreId().compareTo(item2.getStoreId());
			if (storeIdInt != 0) {
				return storeIdInt;
			}
			int expriedDateInt = item2.getExpiredDate().compareTo(item1.getExpiredDate());
			if (expriedDateInt != 0) {
				return expriedDateInt;
			}
			return item2.getId().compareTo(item1.getId());
		});
		generate("5. Sx mã cửa hàng tăng dần, ngày hết hạn giảm dần, giảm dần theo mã mặt hàng", items);
		
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
	
	private static void sort(Item[] items, ItemComp itemComp) {
		int length = items.length;
		for (int round = 0; round < length - 1; round++) {
			for (int i = round + 1; i < length; i++) {
				if (itemComp.compare(items[round], items[i]) > 0) {
					swap(items, round, i);
				}
			}
		}
	}
}