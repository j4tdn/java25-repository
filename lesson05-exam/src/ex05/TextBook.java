package ex05;

public class TextBook extends Book {

	private String status;
	
	public TextBook() {
	}

	public TextBook(String bookid, double price, String producer, String status) {
		super(bookid, price, producer);
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
		return "TextBook [ bookid= " + getBookid()
				+ ", getPrice()= " + getPrice() 
				+ ", getProducce()= " + getProducer() 
				+ "status= " + status + "]";
	}

	
	
	
	

	
	
	
	
	
}
