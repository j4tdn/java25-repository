package ShopA;

public class ReferenBook extends Book {
	private double taxPercent;

	public ReferenBook(String code, double price, String publisher, double taxPercent) {
		super(code, price, publisher);
		this.taxPercent = taxPercent;
	}
	
	@Override
	public double getPrice() {
		return getPrice()*(1 + taxPercent / 100);
	}
	
	public double getTaxPercent() {
		return taxPercent;
	}

	@Override
	public String toString() {
		return "ReferenBook [taxPercent=" + taxPercent + ", getPrice()=" + getPrice() + ", getTaxPercent()="
				+ getTaxPercent() + "]";
	}
	
	
}
