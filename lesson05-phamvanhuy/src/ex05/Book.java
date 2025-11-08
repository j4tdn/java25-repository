package ex05;

public class Book {
	public String bookId;
	public double price;
	public String publisher;
	
	public Book(String bookId, double price, String publisher) {
		this.bookId = bookId;
		this.price = price;
		this.publisher = publisher;
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double sum() {
		return price;
	}
	@Override
	public String toString() {
		return "book [bookId=" + bookId + ", price=" + price + ", publisher=" + publisher + "]";
	}
	
	
}
