package inheritance.cclass;

import java.math.BigDecimal;

public class TextBook extends Book {
	
	// status: new / old
	private Status status;
	private BigDecimal discountInPercent;
	
	public TextBook() {
		
	}
	
	public TextBook(String id, String name, BigDecimal salesPrice, 
			Status status, BigDecimal discountInPercent) {
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
	public String toString() {
		return "TextBook [status=" + status + ", discountInPercent=" + discountInPercent + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getSalesPrice()=" + getSalesPrice() + "]";
	}	

}
