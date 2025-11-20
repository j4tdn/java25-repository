package bean;

public class ReferenceBook extends Book {
	
	private Double taxInPercent;
	
	public ReferenceBook() {
	}
	
	public ReferenceBook(String id, Double salesPrice, String publisher, Double taxInPercent) {
		super(id, salesPrice, publisher);
		this.taxInPercent = taxInPercent;
	}

	public Double getTaxInPercent() {
		return taxInPercent;
	}
	
	public void setTaxInPercent(Double taxInPercent) {
		this.taxInPercent = taxInPercent;
	}
	
	@Override
	public Double calculateSalesPrice() {
		double salesPrice = getSalesPrice();
		if (this instanceof ReferenceBook rb) {
			salesPrice *= ((100d + rb.getTaxInPercent()) / 100d);
		}
		return salesPrice;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", taxInPercent = " + getTaxInPercent() + "%";
 	}
	
}
