package lesson05;

public class TextBook extends Book {
	private String status;
	
	public TextBook() {
		// TODO Auto-generated constructor stub
	}

	public TextBook(String bookNumber, double price, String seller, String status) {
		super(bookNumber, price, seller);
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TextBook [getBookNumber()=" + getBookNumber() + ", getPrice()=" + getPrice()
				+ ", getSeller()=" + getSeller() + "status=" + status + "]";
	}
	
	
	

}
