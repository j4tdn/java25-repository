package inheritance.cclass;

import java.math.BigDecimal;

// this: dai dien cho doi tuong hien tai(co the goi ham, tt cua class hien taiva ham,tt dc thua ke tu cha)
//	   : goi den cac constructor o class hien tai
// super:
//

public class TextBook extends Book{
	private Status status;
	private BigDecimal discountInPercent;
	
	public TextBook() {
	}
	
	public TextBook(String id, String name, BigDecimal salePrices, Status status, BigDecimal discountInPercent) {
		super(id, name, salePrices);
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
		return "TextBook [status=" + getStatus() + ", discountInPercent=" + getDiscountInPercent() + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getSalePrices()=" + getSalePrices() + "]";
	}
	
}
