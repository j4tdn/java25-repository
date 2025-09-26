package ex01;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Order {
	private Customer customer;
	private ItemDetail[] itemDetails;
	private LocalDateTime datetime;
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(Customer customer, ItemDetail[] itemDetails, LocalDateTime datetime) {
		super();
		this.customer = customer;
		this.itemDetails = itemDetails;
		this.datetime = datetime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ItemDetail[] getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(ItemDetail[] itemDetails) {
		this.itemDetails = itemDetails;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "Order [customer=" + customer + ", itemDetails=" + Arrays.toString(itemDetails) + ", datetime="
				+ datetime + "]";
	}
	
	LocalDateTime getOrderDate() {
		return datetime;
	}
	
}
