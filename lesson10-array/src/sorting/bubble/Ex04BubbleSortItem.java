package sorting.bubble;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import bean.Item;
import function.lambda.ItemComp;
import static utils.PrintUtils.*;
import static model.DataModel.*;

public class Ex04BubbleSortItem {

	public static void main(String[] args) {
		Item[] items = mockItem();

		// 1. Sắp xếp tăng dần theo giá bán
		sort(items, (it1, it2) -> {
			return it1.getSalesPrice().compareTo(it2.getSalesPrice());
		});

		generate("1. Sắp xếp tăng dần theo giá bán", items);

		sort(items, (item1, item2) -> {
			return item1.getName().compareTo(item2.getName());
		});

		generate("2. Sắp xếp tăng dần theo tên mặt hàng", items);

		sort(items, (item1, item2) -> {
			return item1.getExpiredDate().compareTo(item2.getExpiredDate());
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
			int expiredDateInt = item2.getExpiredDate().compareTo(item1.getExpiredDate());
			if (expiredDateInt != 0) {
				return expiredDateInt;
			}
			return item2.getId().compareTo(item1.getId());
		});
		generate("5. Sắp xếp mã cửa hàng tăng dần, ngày hết hạn giảm dần, giảm dần theo mã mặt hàng", items);

//	    NULL cho Item
		// NULL cho Item's attribute(s)

		items[2] = null;
		items[6] = null;
		items[5].setSalesPrice(null);
		items[7].setSalesPrice(null); // item52, item71

		sort(items, (item1, item2) -> {
			if(item1 == null) {
				return -1;
			}
			
			if(item2 == null) {
				return 1;
			}
			
			BigDecimal sp1 = item1.getSalesPrice();
			BigDecimal sp2 = item2.getSalesPrice();
			if(sp1 == null) {
				return -1;
			}
			if(sp2 == null) {
				return 1;
			}
			return sp1.compareTo(sp2);
		});

		generate("6. Xử lý trường hợp giá trị NULL", items);

	}

	

	private static void sort(Item[] items, ItemComp itemComp) {
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - i - 1; j++) {
				if (itemComp.compare(items[j], items[j + 1]) > 0) {
					swap(items, j, j + 1);
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
