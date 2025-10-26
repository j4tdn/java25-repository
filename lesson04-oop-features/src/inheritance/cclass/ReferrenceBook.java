package inheritance.cclass;

import java.math.BigDecimal;

public class ReferrenceBook extends Book {
	private BigDecimal tax;
	public ReferrenceBook() {
		
	}
	public ReferrenceBook(String id, String name, BigDecimal salesPrice,BigDecimal tax) {
		super(id,name,salesPrice);
		this.tax = tax;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	@Override
	public boolean isMatchedForSales() {
		return getTax().doubleValue() >3d;
	}
	@Override
	public String toString() {
		return "TextBook [id()= "  + getId() + ", Name()=" + getName() + ", salesPrice()= "+ getSalesPrice()
				+"tax="+getTax()+ "]";
	}
	
}
