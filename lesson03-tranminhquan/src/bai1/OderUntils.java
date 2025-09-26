package bai1;

import java.time.LocalDate;
import java.time.Month;

public class OderUntils {
	private OderUntils() {
	}

	public static double export(Oder oder) {
		double totolOfMoney = 0;
		ItemDetail[] ids = oder.getItemDetails();
		for(ItemDetail id: ids) {
			Item item = id.getItem();
			int quantity = id.getQuantity();
			double idCost = item.getCost() * quantity;
			if(item.getCost() > 590 && LocalDate.of(2025, Month.MAY, 8).isEqual(oder.getOrderDate().toLocalDate())){
				idCost *= 0.9;
			}
			totolOfMoney += idCost;
		}
		return totolOfMoney;
	}
}