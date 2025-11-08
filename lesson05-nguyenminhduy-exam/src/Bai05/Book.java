package Bai05;

public class Book {
	
	public String id, publisher;
	public double price;
	
	public Book() {
	}

	public Book(String id, String publisher, double price) {
		this.id = id;
		this.publisher = publisher;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double Total() {
		return price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", publisher=" + publisher + ", price=" + price + "]";
	}

}
