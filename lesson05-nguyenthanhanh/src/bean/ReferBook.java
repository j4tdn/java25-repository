package bean;

public class ReferBook extends Book {
	
	private Double tax;
	
	public ReferBook(String bookId, Double priceOfUnit, String publisher, Double tax) {
		super(bookId, priceOfUnit, publisher);
		this.tax = tax;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "ReferBook [tax=" + tax + ", getBookId()=" + getBookId() + ", getPriceOfUnit()=" + getPriceOfUnit()
				+ ", getPublisher()=" + getPublisher() + "]";
	}
	

}
