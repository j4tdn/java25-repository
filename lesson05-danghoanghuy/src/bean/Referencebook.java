package bean;

public class Referencebook extends Book {
	private double tax;
	
	public Referencebook() {
	}

	public Referencebook(String id, double price, String publisher, double tax) {
		super(id, price, publisher);
		this.tax = tax;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	@Override
	public double pay() {
		return this.getPrice()*(1 + this.getTax());
	}

	@Override
	public String toString() {
		return "Referencebook [tax=" + tax + ", Id=" + getId() + ", Price=" + getPrice() + ", Publisher="
				+ getPublisher() + "]";
	}
	
}
