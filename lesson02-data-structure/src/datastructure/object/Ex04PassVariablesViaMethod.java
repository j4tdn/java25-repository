package datastructure.object;

import bean.Item;

public class Ex04PassVariablesViaMethod {
	public static void main(String[] args) {
		// Truyen tham so qua ham
		
		
		// KDL nguyen thuy
		int a1 = 5;
		System.out.println("a1 before: " + a1);
		update(a1);
		System.out.println("a1 after: " + a1);
		
		// KDL doi tuong
		Item item1 = new Item(1, 'A', 22);
	}
	private static void update(int source) {
		source = 999;
	}
}
