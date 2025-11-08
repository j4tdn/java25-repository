package bean;

public class ReferBook extends Book {
	private Double tax;

	public ReferBook() {

	}

	public ReferBook(String idBook, Double price, String nxb, Double tax) {
		super(idBook, price, nxb);
		this.tax = tax;
	}

	public Double getTax() {
		return tax;

	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "ReferBook [tax=" + tax + ", getTax()=" + getTax() + ", getIdBook()=" + getIdBook() + ", getPrice()="
				+ getPrice() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

}
