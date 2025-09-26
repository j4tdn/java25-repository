package ex01;

import java.time.LocalDate;
import java.time.Month;

public class OrderUntils {
    private OrderUntils() {

    }

    public static double export(Order order) {
        double totalOfMoney = 0;
        ItemDetail[] ids = order.getItemDetails();
        for (ItemDetail id : ids) {
            Item item = id.getItem();
            int quantity = id.getQuantity();
            double idCost = item.getCost() * quantity;

            // Giảm giá 10% nếu đơn hàng vào đúng ngày 24/07/2025 và giá > 590
            if (item.getCost() > 590 &&
                LocalDate.of(2025, Month.JULY, 24)
                        .isEqual(order.getOrderDate().toLocalDate())) {
                idCost *= 0.9;
            }

            totalOfMoney += idCost;
        }
        return totalOfMoney;
    }
}
