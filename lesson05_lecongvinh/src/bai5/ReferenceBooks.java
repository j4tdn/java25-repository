package bai5;

public class ReferenceBooks {
	private String ID;
	private double Price;
	private String Author;
	private float Tax;
	
	 public ReferenceBooks() {
		 
	}

	public ReferenceBooks(String iD, double price, String author, float tax) {
		super();
		ID = iD;
		Price = price;
		Author = author;
		Tax = tax;
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

	public float getTax() {
		return Tax;
	}

	public void setTax(float tax) {
		Tax = tax;
	}

	@Override
	public String toString() {
		return "ReferenceBooks [ID=" + ID + ", Price=" + Price + ", Author=" + Author + ", Tax=" + Tax + "]";
	}
	 
}
