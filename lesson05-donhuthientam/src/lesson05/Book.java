package lesson05;

public class Book {
	private String bookNumber;
	private double price;
	private String seller;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String bookNumber, double price, String seller) {
		super();
		this.bookNumber = bookNumber;
		this.price = price;
		this.seller = seller;
	}

	public String getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", price=" + price + ", seller=" + seller + "]";
	}
	
	

}
