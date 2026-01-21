package bean;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Item {
	private Integer id;
	private String name;
	private BigDecimal salesPrice;
	private LocalDate expriedDate;
	private Integer storeId;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(Integer id, String name, BigDecimal salesPrice, LocalDate expriedDate, Integer storeId) {
		super();
		this.id = id;
		this.name = name;
		this.salesPrice = salesPrice;
		this.expriedDate = expriedDate;
		this.storeId = storeId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public LocalDate getExpriedDate() {
		return expriedDate;
	}

	public void setExpriedDate(LocalDate expriedDate) {
		this.expriedDate = expriedDate;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Item that)) {
			return false;
		}
		return getId() == that.getId();
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", salesPrice=" + salesPrice + ", expriedDate=" + expriedDate
				+ ", storeId=" + storeId + "]";
	}
	
	

}
