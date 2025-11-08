package lesson05;

public class ReferenceBook extends Book {
	private double tax;

	public ReferenceBook() {
		// TODO Auto-generated constructor stub
	}

	public ReferenceBook(String bookNumber, double price, String seller, double tax) {
		super(bookNumber, price, seller);
		this.tax = tax;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "ReferenceBook [getBookNumber()=" + getBookNumber() + ", getPrice()=" + getPrice()
				+ ", getSeller()=" + getSeller() + "tax=" + tax + "]";
	}
	
	

}
