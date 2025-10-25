package inheritance.cclass;

import java.math.BigDecimal;

public class TextBook extends Book{
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
		return "TextBook [id = " + getId() + ", getName=" + getName() + ", getSalesPrice=" + getSalesPrice() 
		+ "status=" + status + ", discountInPercent=" + discountInPercent + " ]";
	}
	
}
