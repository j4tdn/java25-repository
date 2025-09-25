package shopping;

import java.time.LocalDate;

/**
 *  Utility of Order Class
 *  Normally: Utility is place where contains utility methods
 *  No cares created class's object
 */

public class OrderUtils {
	
	public OrderUtils() {
	}
	
	public static double export(Order order) {
		double totalOfMoney = 0;
		ItemDetail[] ids = order.getItemDetails();
		
		System.out.println("Thong tin san pham:");
		for(ItemDetail id: ids) {
			Item item = id.getItem();
			System.out.println(item);
		}
		
		for(ItemDetail id: ids) {
			Item item = id.getItem();
			int quantity = id.getQuantity();
			
			double idCost = item.getCost() * quantity;
			if(item.getCost() > 590 && LocalDate.of(2021, 5, 5).isEqual(order.getOrderDate().toLocalDate())) {
				idCost *= 0.9;
			}
			totalOfMoney += idCost;
		}
		
		return totalOfMoney;
	}
}
