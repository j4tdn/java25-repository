package view.list;

import java.util.List;


import bean.Item;
import model.DataModel;

import static utils.PrintUtils.*;
import static model.DataModel.*;

public class Ex03CustomObjectType {
	
	public static void main(String[] args) {
		
		List<Item> items = DataModel.mockItems();
		System.out.println("1. Kích thước items: " + items.size());
//		generate("1. Danh sách các phần tử", items);
		
		Item itemA2 = new Item(2, "Item A2", bd ("181"), toDate("12/12/2022"), 101);
		
		boolean isExists = items.contains(itemA2);
		System.out.println("2. Kiếm tra iteamA2 có tồn tại hay khong ? " + isExists);
		
		Item itemB4 = new Item(4, "Item B4", bd("888"), toDate("16/12/2023"), 101);
		items.remove(itemB4);
//		generate("3. Danh sách phần tử(Sau khi xóa iteamB4", items);
		
		
		
	}

}
