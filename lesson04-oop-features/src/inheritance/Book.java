package inheritance;

import java.math.BigDecimal;

public class Book {
	private String id;
	private String name;
	private BigDecimal salesPrice;
	private Book that;
	public Book() {
		
	}
	public Book(String id, String name, BigDecimal salesPrice) {
		super();
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		that = null;
		return getId().equals(that.getId());
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", salesPrice=" + salesPrice + "]";
	}
	
}
