package view.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static utils.PrintUtils.*;

import bean.Item;

public class Ex02MapPrinciple {
	/** 
	 * Bài toán
	 * - Lưu danh sách các mặt hàng và danh sách địa chỉ cửa hàng sẽ bán mặt hàng đó
	 * 
	 * K: Item
	 * V: List<String>
	 * 
	 * - Cơ chế phát hiện key đã tồn tại trong map chưa
	 * - Khi put một phần tử mới vào trong map kiểm tra 
	 * - key đã tồn tại bên trong map hay chưa thông qua so sánh
	 *   - hashing value: hashcode (mặc định là địa chỉ JVM cấp phát cho đối tượng)
	 *   - value: equals (mặc định dùng Objects#equals so sánh địa chỉ của đối tượng)
	 *   
	 * Thay vì dùng địa chỉ để xác định key đã tồn tại chưa, dùng giá trị của key bằng cách
	 * override hàm hashcode, equals theo giá trị thuộc tính của key
	 * 
	 * VD: 2 keys Item sẽ trùng nhau khi chung Id
	 * - override hash code theo id
	 * -          equals
	 * 
	 * */

	public static void main(String[] args) {
		Map<Item, List<String>> items = new HashMap<>();
		
		items.put(new Item(1, "Item 1"), List.of("A1, A2, A3"));
		items.put(new Item(2, "Item 2"), List.of("B1, B2, B3"));
		items.put(new Item(3, "Item 3"), List.of("C1, C2, C3"));
		items.put(new Item(4, "Item 4"), List.of("D1, D2, D3"));

		items.put(new Item(2, "Item 2"), List.of("K1, K2, K3"));
		
		System.out.println("items size: "+items.size());
		generate("1. Danh sách mặt hàng và các cửa hàng liên quan", items);
	}
}
