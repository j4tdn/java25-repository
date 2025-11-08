package ex05;

public class TextBook extends Book {
	
	private String Status;

	public TextBook(String bookId, double price, String publisher, String status) {
		super(bookId, price, publisher);
		Status = status;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	
	@Override
	public String toString() {
		return "TextBook [bookId=" + bookId + ", price=" + price + ", publisher=" + publisher + ", Status=" + Status
				+ "]";
	}
}
