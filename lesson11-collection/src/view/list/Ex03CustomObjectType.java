package view.list;

import java.util.List;

import bean.Item;
import model.DataModel;

import static utils.PrintUtils.*;
import static model.DataModel.*;

public class Ex03CustomObjectType {
	
	public static void main(String[] args) {
		
		// compile: List
		// runtime: ArrayList
		List<Item> items = DataModel.mockItems();
		
		System.out.println("1. Kích thước items: " + items.size());
		generateItems("1. Danh sách các phần tử", items);
		
		Item itemA2 = new Item(2, "Item A2", bd("181"), toDate("12/12/2022"), 101);
		
		// Kiểm tra itemA2 có tồn tại trong items không ?
		// for (int i = start; i < end; i++) {
        //     if (o.equals(es[i])) {
        //        return i;
        //     }
		// }
		// Duyệt từng phần tử trong items, nếu có phần tử nào equals với itemA2 --> true else(false)
		// Hàm equals mặc định sử dụng từ class Object --> so sánh == địa chỉ
		// Muốn so sánh theo giá trị bên trong các thuộc tính của class --> override hàm equals
		boolean isExists = items.contains(itemA2);
		System.out.println("2. Kiểm tra itemA2 có tồn tại trong items không --> " + isExists);
		
		
		// Duyệt từng phần tử trong items, nếu có phần tử nào equals với itemB4 --> thực hiện xóa
		Item itemB4 = new Item(4, "Item B4", bd("888"), toDate("16/12/2023"), 101);
		items.remove(itemB4);
		generateItems("3. Danh sách các phần tử(sau khi xóa itemB4)", items);
		
		// Best practice: Khi tạo class làm object lưu trữ --> constructor, getter/setter, equals, toString
	}
	
}
