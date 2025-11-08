package bean;

public class ReferBook extends Book {
// thuế: tax
	private double tax;

	public ReferBook() {
		
	}

	public ReferBook(int id, double price, String publisher) {
		super(id, price, publisher);
		// TODO Auto-generated constructor stub
	}

	public ReferBook(double tax) {
		super();
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
		return "ReferBook [tax=" + tax + ", getTax()=" + getTax() + ", getId()=" + getId() + ", getPrice()="
				+ getPrice() + ", getPublisher()=" + getPublisher() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
