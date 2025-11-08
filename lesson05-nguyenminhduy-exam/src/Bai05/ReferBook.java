package Bai05;

public class ReferBook extends Book {
	
	private double tax;
	
	public ReferBook() {
	}

	public ReferBook(String id, String publisher, double price, double tax) {
		super(id, publisher, price);
		this.tax = tax;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	@Override
	public double Total() {
		return price * (1 + tax);
	}

	@Override
	public String toString() {
		return "ReferBook [tax=" + tax + ", id=" + id + ", publisher=" + publisher + ", price=" + price + ", getTax()="
				+ getTax() + "]";
	}

	
	

}
