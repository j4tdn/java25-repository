package inheritance;

import java.math.BigDecimal;

public class TextBook extends Book {
	
	private Status status;
	private BigDecimal discounInpercent;
	public TextBook() {
		super();
	}
	public TextBook(String id, String name, BigDecimal salesPrice,Status status, BigDecimal discounInpercent) {
		super(id, name, salesPrice);
		this.status = status;
		this.discounInpercent = discounInpercent;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public BigDecimal getDiscounInpercent() {
		return discounInpercent;
	}
	public void setDiscounInpercent(BigDecimal discounInpercent) {
		this.discounInpercent = discounInpercent;
	}
	@Override
	public String toString() {
		return "Book [id=" + getId() + ", name=" + getName() + ", salesPrice=" + getSalesPrice() +"TextBook [status=" + status + ", discounInpercent=" + discounInpercent + "]";
	}
	
	
}
