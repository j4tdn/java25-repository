package lesson05.exam.bean;

public class ReferBook extends Book{
	private double tax;
	

	public ReferBook(long bookId, int price, String publish, double tax) {
		super(bookId, price, publish);
		this.tax = tax;
	}
	

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}


	@Override
	public double getTotalPrice() {
		return price + (1 + tax) ;
	}


	@Override
	public String toString() {
		return "ReferBook [tax=" + tax + ", bookId=" + bookId + ", price=" + price + ", publish=" + publish + "]";
	}
	
	
	
}
