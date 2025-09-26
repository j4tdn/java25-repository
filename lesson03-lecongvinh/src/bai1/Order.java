package bai1;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Order {

	private Customer customer;
	private ItemDetail[] itemDetail;
	private LocalDateTime orderDate;
	
	public Order() {
		
	}
	

	


	public Order(Customer customer, ItemDetail[] itemDetail, LocalDateTime orderDate) {
		
		this.customer = customer;
		this.itemDetail = itemDetail;
		this.orderDate = orderDate;
	}





	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ItemDetail[] getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(ItemDetail[] itemDetail) {
		this.itemDetail = itemDetail;
	}

	public LocalDateTime getOrderDatetime() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime OrderDate) {
		this.orderDate = orderDate;
	}





	@Override
	public String toString() {
		return "Order [customer=" + customer + ", itemDetail=" + itemDetail + ", orderDate=" + orderDate + "]";
	}





	public double export() {
	
		double totalofMoney =0;
		ItemDetail[] ids = getItemDetail();
		
		// For index
		//for(int i =0; i<ids.length; i++) {
			//ItemDetail id =ids[i];
			
		//}
		
		//For each
		for(ItemDetail id : ids) {
			Item item = id.getItem();
			int quantity = id.getQuantity();
			double idCost = item.getCost() *quantity;
			if(item.getCost()>400 && LocalDate.of(2025, Month.SEPTEMBER, 26).isEqual(getOrderDatetime().toLocalDate())) {
				idCost *=0.9;
				
			}
			
				totalofMoney += idCost;
		}
		
		
		return totalofMoney;
	}

	
	
	
}
