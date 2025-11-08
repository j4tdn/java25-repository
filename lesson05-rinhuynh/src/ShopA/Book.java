package ShopA;

public class Book {
	
	private String code;
	private double price;
	private String publisher;
	
	public Book() {
	}

	@Override
	public String toString() {
		return "Book [code=" + code + ", price=" + price + ", publisher=" + publisher + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Book(String code, double price, String publisher) {
		super();
		this.code = code;
		this.price = price;
		this.publisher = publisher;
	}
	
	

}
