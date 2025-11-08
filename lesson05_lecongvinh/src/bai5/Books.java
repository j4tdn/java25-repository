package bai5;

public class Books {
	
	private String ID;
	private double Price;
	private String Author;
	private String Status;
	
	public Books() {
		 
	}

	public Books(String iD, double price, String author, String status) {
		super();
		ID = iD;
		Price = price;
		Author = author;
		Status = status;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	public boolean FindPrice() {
		return this.Price >100 && this.Price<200;
	}
	
	@Override
	public String toString() {
		return "Books [ID=" + ID + ", Price=" + Price + ", Author=" + Author + ", Status=" + Status + "]";
	}
	
}
