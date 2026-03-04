package sorting.bubble;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import bean.Item;
import function.ItemComp;
import util.PrintUtils;

public class Ex04BubbleSortItem {
	
	/*
	 SX mang ddoi tuong, gia tri cua tung phan tu co the ton tai hoac la NULL
	 Neu k xu ly cho gia tri la NULL --> NPE khi so sanh de hoan vi
	 
	 Xu ly
	 ---------
	 B1: Xu ly cho cac phan tu NULL
	 	--> NULL first/last
	 
	 B2: Xu ly cho cac phan tu con lai (!NULL)
	 	--> Tang/giam dan ==> theo thuoc tinh (1 || N) nao
	 	--> Gia tri cua thuoc tinh cung co the bi NULL
	 		2.1 NULL first/ last
	 		2.2 Xu ly cac doi tuong co gia tri thuoc tinh != NULL
	 */
	
	// String: so sanh gia tri cua doi tuong roi hoan vi doi tuong
	// Item: so sanh gia tri thuoc tinh cua doi tuong roi hoan vi doi tuong
	
	public static void main(String[] args) {
		
		Item[] items = mockData(); 
		
		// 1. SX tang dan theo gia ban
		sort(items, (i1, i2) -> {
			return i1.getSalesPrice().compareTo(i2.getSalesPrice());
		});
		PrintUtils.generate("1. SX tang dan theo gia ban", items);
		
		// 2. SX giam dan theo ten mat hang
		sort(items, (i1, i2) -> {
			return i2.getName().compareTo(i1.getName());
		});
		PrintUtils.generate("2. SX giam dan theo ten mat hang", items);
		
		// 3. Sap xep ngay het han tang dan
		sort(items, (i1, i2) -> {
			return i1.getExpiredDate().compareTo(i2.getExpiredDate());
		});
		PrintUtils.generate("3. Sap xep ngay het han tang dan", items);
		
		// 4. SX ma cua hang giam dan, gia ban tang dan
		sort(items, (i1, i2) -> {
			int storeIdInt = i2.getSalesPrice().compareTo(i1.getSalesPrice());
			if(storeIdInt != 0) {
				return storeIdInt;
			}
			return i1.getSalesPrice().compareTo(i2.getSalesPrice());
		});
		PrintUtils.generate("4. SX ma cua hang giam dan, gia ban tang dan", items);
		
		// 5. SX ma cua hang giam dan, ngay het han giam dan, tang dan theo ma mat hang
		sort(items, (i1, i2) -> {
			int storeIdInt = i1.getStoreId().compareTo(i2.getStoreId());
			if(storeIdInt != 0) {
				return storeIdInt;
			}
			int expriedDataInt = i2.getExpiredDate().compareTo(i1.getExpiredDate());;
			if(expriedDataInt != 0) {
				return expriedDataInt;
			}
			return i2.getId().compareTo(i1.getId());
		});
		PrintUtils.generate("5. SX ma cua hang giam dan, ngay het han giam dan, tang dan theo ma mat hang", items);
		
		items[2] = null;
		items[6] = null;
		items[5].setSalesPrice(null);
		items[7].setSalesPrice(null);
		
		// 6. Xu ly truong hop gia tri NULL
		// 		NULL cho item
		//		NULL cho item's attribute(s)
		sort(items, (i1, i2) -> {
			// NULL first
			if(i1 == null) {
				return -1;
			}
			if(i2 == null) {
				return 1;
			}
			
			// Tang dan theo gia ban (NULL last)
			BigDecimal sp1 = i1.getSalesPrice();
			BigDecimal sp2 = i2.getSalesPrice();
			if(sp1 == null && sp2 != null) {
				return 1;
			}
			if(sp2 == null) {
				return -11;
			}
			
			return i1.getSalesPrice().compareTo(i2.getSalesPrice());
		});
		PrintUtils.generate("6. Xu ly truong hop gia tri NULL", items);
		
	}
	
	private static Item[] mockData() {
		return new Item[] {
			new Item(1, "Item X1", bd("120"), toDate("10/12/2020"), 101),
			new Item(2, "Item A2", bd("181"), toDate("12/12/2020"), 101),
			new Item(3, "Item Z3", bd("111"), toDate("14/12/2020"), 101),
			new Item(4, "Item B4", bd("888"), toDate("16/12/2020"), 105),
			new Item(51, "Item K2", bd("123"), toDate("16/12/2020"), 105),
			new Item(52, "Item K1", bd("456"), toDate("16/12/2020"), 105),
			new Item(52, "Item K1", bd("789"), toDate("16/12/2020"), 105),
			new Item(71, "Item T9", bd("777"), toDate("16/12/2020"), 107),
			new Item(73, "Item T8", bd("222"), toDate("16/12/2020"), 107),
			new Item(72, "Item T7", bd("555"), toDate("16/12/2020"), 107),
		};
	}
	
	private static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
	
	private static LocalDate toDate(String dMy) {
		return LocalDate.parse(dMy, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	private static void sort(Item[] items, ItemComp itemComp) {
		for(int i = 0; i < items.length; i++) {
			for(int j = 0; j < items.length - i - 1; j++) {
				if(itemComp.compare(items[j], items[j+1]) > 0) {
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
