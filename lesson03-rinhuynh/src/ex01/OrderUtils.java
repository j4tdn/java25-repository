package ex01;

import java.time.LocalDate;
import java.time.Month;

public class OrderUtils {

	public static String export(Order order) {
		
        StringBuilder sb = new StringBuilder();
        sb.append("===== HÓA ĐƠN =====\n");
        sb.append("Khách hàng: ").append(order.getCustomer().getName()).append("\n");
        sb.append("SĐT: ").append(order.getCustomer().getPhone()).append("\n");
        sb.append("Địa chỉ: ").append(order.getCustomer().getAddress()).append("\n");
        sb.append("Ngày mua: ").append(order.getOrderDate().toLocalDate()).append("\n");
        sb.append("Danh sách sản phẩm:\n");
		
		double totalOfMoney = 0;
		ItemDetail[] ids = order.getItemDetails();
		for (ItemDetail id : ids) {
			Item item = id.getItem();
			int quantity = id.getQuantity();
			double idCost = item.getCost() * quantity;
			if (item.getCost() > 590 && LocalDate.of(2021, Month.MAY, 8).isEqual(order.getOrderDate().toLocalDate())) {
				idCost *= 0.9;
			}
			totalOfMoney += idCost;
			
            sb.append("- ").append(item.getId())
            .append(" | ").append(item.getOs())
            .append(" | ").append(item.getColor())
            .append(" | SL: ").append(quantity)
            .append(" | Thành tiền: ").append(idCost).append("\n");

		}

        sb.append("TỔNG TIỀN PHẢI TRẢ: ").append(totalOfMoney).append("\n");
        return sb.toString();
	}

}
