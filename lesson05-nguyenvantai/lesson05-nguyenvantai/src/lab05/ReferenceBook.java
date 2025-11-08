package lab05;

public class ReferenceBook extends Book {
	private double tax;

	public ReferenceBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReferenceBook(String bookID, double price, String publisher, double tax) {
		super(bookID, price, publisher);
		this.tax = tax;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getTotalPrice() {

		return price * (1 + tax);
	}

	@Override
	public String toString() {
		return "ReferenceBook [tax=" + tax + ", bookID=" + bookID + ", price=" + price + ", publisher=" + publisher
				+ ", getTotalPrice()=" + getTotalPrice() + ", getBookID()=" + getBookID() + ", getPrice()=" + getPrice()
				+ ", getPublisher()=" + getPublisher() + ", toString()=" + super.toString() + "]";
	}
}
