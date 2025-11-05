package inheritance.cclass;

import java.math.BigDecimal;

//this: đại diện cho đối tượng hiện tại(có thể gọi các hàm, tt của class hiện tại và hàm, tt được kế thừua từ cha
//    : gọi đến các cóntructor ở class hiện tại

//super: đại diện cho đối tượng hiện tại(có thể gọi các hàm, tt của class hiện tại và hàm, tt được kế thừua từ cha
//: gọi đến các cóntructor ở class hiện tại


public class TextBook extends Book {

	private Status status;
	private BigDecimal discountInPercent;
	
	public TextBook() {
	}

	public TextBook(String id, String name, BigDecimal salesPrice,Status status, BigDecimal discountInPercent) {
		super(id, name, salesPrice);
		this.status = status;
		this.discountInPercent = discountInPercent;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public BigDecimal getDiscountInPercent() {
		return discountInPercent;
	}

	public void setDiscountInPercent(BigDecimal discountInPercent) {
		this.discountInPercent = discountInPercent;
	}
	
	public boolean isOld() {
		return getStatus() == Status.OLD;
	}
	
	public boolean isMatchedForSales() {
		return getStatus() == Status.OLD && getDiscountInPercent().doubleValue() > 2d;
	}
	
	@Override
	public String toString() {
		return "TextBook [status=" + status + ", discountInPercent=" + discountInPercent + ", Id()=" + getId()
				+ ",Name()=" + getName() + ", SalesPrice()=" + getSalesPrice() + "]";
	}
	
	
	
	
}
