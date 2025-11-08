package ex05;

public class ReferenceBook extends Book{
	private double tax;

	public ReferenceBook(String bookId, double price, String publisher, double tax) {
		super(bookId, price, publisher);
		this.tax = tax;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "ReferenceBook [bookId=" + bookId + ", price=" + price + ", publisher=" + publisher + ", tax=" + tax
				+ "]";
	}
}
