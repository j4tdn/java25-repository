package view.list;

import java.util.List;

import bean.Item;
import model.DataModel;

import static util.PrintUtils.*;
import static model.DataModel.*;

public class Ex03CustomObjectType {

	public static void main(String[] args) {
		
		// compile: List
		// runntime: ArrayList
		List<Item> items = DataModel.mockItems();
		
		System.out.println("Kich thuoc items: " + items.size());		
		generateItems("1. DS cac phan tu", items);
		
		Item itemA2 = new Item(2, "Item A2", bd("181"), toDate("12/12/2020"), 101);
		
		// Kiem tra itemA2 co ton tai trong items k?
		// Duyet tung phan tu trong items, neu co phan tu nao equals voi itemA2 --> true else(false)
		// Ham equals mac dinh su dung tu class Object --> so sanh == dia chi
		// Muon so sanh theo gia tri ben trong cac thuoc tinh cua class --> override ham equals
		boolean isExists = items.contains(itemA2);
		System.out.println("2. Kiem tra itemsA2 co ton tai trong items k --> " + isExists);
	
		Item itemB4 = new Item(4, "Item B4", bd("888"), toDate("16/12/2020"), 105);
		items.remove(itemB4);
		generateItems("3. DS sau khi xoa itemB4", items);
		
		// Best Practice: khi tao class lam object luu tru --> constructor, getter/setter, equals, toString
		
	}
	
}
