package bean;

public class Book {
// Id, giá, nhà xuất bản: publisher
	private int Id ; 
	private double price;
	private String publisher;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, double price, String publisher) {
		super();
		Id = id;
		this.price = price;
		this.publisher = publisher;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	@Override
	public String toString() {
		return "Book [Id=" + Id + ", price=" + price + ", publisher=" + publisher + "]";
	}
	
	
}
