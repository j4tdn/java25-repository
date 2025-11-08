package bean;

public abstract class Book {

	//▪ Sách giáo khoa: Mã sách, đơn giá, nhà xuất bản, tình trạng (mới, cũ).
	
	private String id;
	private double price;
	private String publisher;
	
	public Book() {
	}

	public Book(String id, double price, String publisher) {
		super();
		this.id = id;
		this.price = price;
		this.publisher = publisher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public abstract double pay();

	@Override
	public String toString() {
		return "Book [id=" + id + ", price=" + price + ", publisher=" + publisher + "]";
	}	
}
