package inheritance.cclass;

import java.math.BigDecimal;

public class Book {

	private String id;
	private String name;
	private BigDecimal salesPrice;

	public Book() {
	}

	public Book(String id, String name, BigDecimal salesPrice) {
		this.id = id;
		this.name = name;
		this.salesPrice = salesPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}
	
	protected boolean isMatchedForSales() {
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Book that)) {
			return false;
		}
		return getId().equals(that.getId());
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", salesPrice=" + salesPrice + "]";
	}
}