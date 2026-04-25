package view.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Item;

import static utils.PrintUtils.*;

public class Ex02MapPrinciple {
	
	
	/*
	 * Bài toán
	 * - lƯu danh sách các mặ hàng và danh scahs địa chỉ cửa hàng sẽ bán mặt hàng đó
	 * 
	 * K: Item
	 * V: List(String)
	 * 
	 * - Cơ chế phát hiện key đã tồn tịa bên trong mao chưa
	 * 
	 * - khi put 1 phần tử mới vào trong map, map kiểm tra
	 * - key đã tồn tại bên trong map hay chưa thông qua so sánh
	 * - hashing value: hashcode(mặc định địa chỉ mà JVM cấp phát cho đối tượng)
	 *- value        : equals   (mặc định dung objects#equals so sánh địa chỉ của đối tượng)
	 *
	 *tahy vì dùng đại chỉ để xác định key đã tồn tại chưa, dùng giá trị của key bằng cách
	 *overide hàm hashcode, equal theo giá trị thuộc tính của key
	 *
	 *VD: 2 Key Item sẽ trùng nhua khi chung id
	 *	- ovveride hash code theo id
	 *	-			equal
	 *				
	 */
	
public static void main(String[] args) {
	Map<Item, List<String>> items = new HashMap<>();
	
	items.put(new Item(1, "Item 1"), List.of("A1, A2, A3"));
	items.put(new Item(2, "Item 2"), List.of("B1, B2, B3"));
	items.put(new Item(3, "Item 3"), List.of("C1, C2, C3"));
	items.put(new Item(4, "Item 4"), List.of("D1, D2, D3"));
	
	items.put(new Item(2, "Item 2"), List.of("K1, K2, K3"));
	
	System.out.println("items size: " + items.size());
	generate("1. Danh sách mặt hàng và cửa hàng liên quan", items);
}
	
}
