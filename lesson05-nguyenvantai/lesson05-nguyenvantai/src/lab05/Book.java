package lab05;

//▪ Khách hàng: Mã khách hàng, họ tên, số điện thoại, địa chỉ
//▪ Sách giáo khoa: Mã sách, đơn giá, nhà xuất bản, tình trạng (mới, cũ).
//▪ Sách tham khảo: Mã sách, đơn giá, nhà xuất bản, thuế %. Biết rằng:
public abstract class Book {
	protected String bookID;
	protected double price;
	protected String publisher;

	public abstract double getTotalPrice();

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String bookID, double price, String publisher) {
		super();
		this.bookID = bookID;
		this.price = price;
		this.publisher = publisher;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
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

	public void setPublished(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", price=" + price + ", published=" + publisher + "]";
	}

}
