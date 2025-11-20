package bean;

import common.BookStatus;

public class TextBook extends Book{
	
	private BookStatus status;

	public TextBook(String id, Double salesPrice, String publisher, BookStatus status) {
		super(id, salesPrice, publisher);
		this.status = status;
	}
	
	public BookStatus getStatus() {
		return status;
	}
	
	public void setStatus(BookStatus status) {
		this.status = status;
	}
	
	@Override
	public Double calculateSalesPrice() {
		double salesPrice = getSalesPrice();
		if (getStatus() == BookStatus.OLD) {
			salesPrice *= 0.7;
		}
		return salesPrice;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", status = " + getStatus();
 	}
	
}
