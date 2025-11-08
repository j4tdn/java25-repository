package lesson05.exam.bean;

public abstract class Book {

	protected long bookId;
	protected int price;
	protected String publish;
	
	public Book() {
	}
	
	
	
	public Book(long bookId, int price, String publish) {
		super();
		this.bookId = bookId;
		this.price = price;
		this.publish = publish;
	}

	public boolean isNhiDongPublish() {
		return publish.equals("Nhi Đồng");
	}
	
	public boolean isPriceLessThan50() {
		return price < 50;
	}
	
	public abstract double getTotalPrice();


	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	
}
