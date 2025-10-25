package inheritance.cclass;

import java.math.BigDecimal;

public class ReferenceBook extends Book {
	private BigDecimal tax;
	
	public ReferenceBook() {
	}

	public ReferenceBook(String id, String name, BigDecimal salePrices, BigDecimal tax) {
		super(id, name, salePrices);
		this.tax = tax;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "ReferenceBook [tax=" + getTax() + ", getId()=" + getId() + ", getName()=" + getName() + ", getSalePrices()="
				+ getSalePrices() + "]";
	}
	
	
}
