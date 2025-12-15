package inheritance.cclass;

import java.math.BigDecimal;

// this : đại diện cho đối tượng hiện tại(có thể gọi các hàm, tt của class hiện tại và hàm, tt được thừa kế từ cha)
//      : gọi đến các constructor ở class hiện tại 

// super: đại diện cho đối tượng cha, chỉ có thể gọi các hàm, tt cho phép từ cha
//      : gọi đến các constructor ở class cha

public class TextBook extends Book {
	
	private Status status;
	private BigDecimal discountInPercent;
	
	public TextBook() {
	}
	
	public TextBook(String id, String name, BigDecimal salesPrice, Status status, BigDecimal discountInPercent) {
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
	
	@Override
	public boolean isMatchedForSales() {
		return getStatus() == Status.OLD && getDiscountInPercent().doubleValue() > 2d;
	}

	@Override
	public String toString() {
		return "TextBook [id=" + getId() + ", name=" + getName() + ", salesPrice=" + getSalesPrice() 
				+ ", status=" + status + ", discountInPercent=" + discountInPercent + "]";
	}
	
	
}