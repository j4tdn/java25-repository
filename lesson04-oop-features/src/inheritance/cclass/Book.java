package inheritance.cclass;

import java.math.BigDecimal;

public class Book {
	private String id;
	private String name;
	private BigDecimal SalesPrice;
	
	public Book() {
	}

	public Book(String id, String name, BigDecimal salesprice) {
		super();
		this.id = id;
		this.name = name;
		this.SalesPrice = salesprice;
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

	public BigDecimal getSalesprive() {
		return SalesPrice;
	}

	public void setSalesprive(BigDecimal salesprice) {
		this.SalesPrice = salesprice;
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
		return "Book [id=" + id + ", name=" + name + ", salesprice=" + SalesPrice + "]";
	}
	
	
	
	

}
