package inheritance.cclass;

import java.math.BigDecimal;

public class Book {
	private String id;
	private String name;
	private BigDecimal salePrices;
	
	public Book(String id, String name, BigDecimal salePrices) {
		this.id = id;
		this.name = name;
		this.salePrices = salePrices;
	}

	public Book() {
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

	public BigDecimal getSalePrices() {
		return salePrices;
	}

	public void setSalePrices(BigDecimal salePrices) {
		this.salePrices = salePrices;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", salePrices=" + salePrices + "]";
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof Book that)) {
			return false;
		}
		return getId().equals(that.getId());
	}
	
}
