package bean;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Item implements Comparable<Item> {

	private Integer id;
	private String name;
	private BigDecimal salesPrice;
	private LocalDate expiredDate;
	private Integer storeId;

	public Item() {
		
	}

	public Item(Integer id, String name, BigDecimal salesPrice, LocalDate expiredDate, Integer storeId) {
		this.id = id;
		this.name = name;
		this.salesPrice = salesPrice;
		this.expiredDate = expiredDate;
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

	public LocalDate getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(LocalDate expiredDate) {
		this.expiredDate = expiredDate;
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
		return "Item [id=" + id + ", name=" + name + ", salesPrice=" + salesPrice + ", expiredDate=" + expiredDate
				+ ", storeId=" + storeId + "]";
	}

	@Override
	public int compareTo(Item o) {
		Item item1 = this;// this, item1 là phần tử đứng trước
		Item item2 = o; // this,item2 là phần tử đứng sau
		return item1.getSalesPrice().compareTo(item2.getSalesPrice());
	}
	
	
	
}