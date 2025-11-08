package lab05;

public class TextBook extends Book {
	private String status;

	public TextBook() {

	}

	public TextBook(String bookID, double price, String publisher, String status) {
		super(bookID, price, publisher);
		this.status = status;
		// TODO Auto-generated constructor stub
	}

	public TextBook(String status) {
		super();
		this.status = status;
	}

	@Override
	public String toString() {
		return "TextBook [status=" + status + ", bookID=" + bookID + ", price=" + price + ", publisher=" + publisher
				+ ", getTotalPrice()=" + getTotalPrice() + ", getBookID()=" + getBookID() + ", getPrice()=" + getPrice()
				+ ", getPublisher()=" + getPublisher() + "]";
	}

	@Override
	public double getTotalPrice() {
		if (status.equalsIgnoreCase("old")) {
			return price * 70;
		}
		return price;
	}

}
