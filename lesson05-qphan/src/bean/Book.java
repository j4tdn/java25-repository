package bean;

public class Book {
	
	private String id;
	private Double salesPrice;
	private String publisher;
	
	public Book() {
	}

	public Book(String id, Double salesPrice, String publisher) {
		this.id = id;
		this.salesPrice = salesPrice;
		this.publisher = publisher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public Double calculateSalesPrice() {
		return getSalesPrice();
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", salesPrice=" + salesPrice + ", publisher=" + publisher + "]";
	}
}
