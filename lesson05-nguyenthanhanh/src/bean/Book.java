package bean;

public class Book {

	private String bookId;
	private Double priceOfUnit;
	private String publisher;
	
	public Book() {
		
	}

	public Book(String bookId, Double priceOfUnit, String publisher) {
		super();
		this.bookId = bookId;
		this.priceOfUnit = priceOfUnit;
		this.publisher = publisher;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Double getPriceOfUnit() {
		return priceOfUnit;
	}

	public void setPriceOfUnit(Double priceOfUnit) {
		this.priceOfUnit = priceOfUnit;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	
}
