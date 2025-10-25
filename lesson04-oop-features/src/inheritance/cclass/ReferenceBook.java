package inheritance.cclass;

import java.math.BigDecimal;

public class ReferenceBook extends Book {
	private BigDecimal tax;
	
	public ReferenceBook() {
		
	}
	public ReferenceBook(String id, String name, BigDecimal salesPrice, BigDecimal tax) {
		super(id, name, salesPrice);
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
		return getTax().doubleValue() > 3d;
	}
	
	@Override
	public String toString() {
		return "TextBook [id = " + getId() + ", getName=" + getName() + ", getSalesPrice=" + getSalesPrice() 
		+ "tax=" + getTax() + "]";
	}
	
	
}
