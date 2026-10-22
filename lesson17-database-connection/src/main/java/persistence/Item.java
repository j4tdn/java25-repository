package persistence;

import java.math.BigDecimal;
import java.util.Objects;

import enumeration.Color;

public class Item {
	
	private Long id;
	private String name;
	private BigDecimal buyPrice;
	private String material;
	private Color color;
	
	public Item() {
	}

	public Item(Long id, String name, BigDecimal buyPrice, String material, Color color) {
		this.id = id;
		this.name = name;
		this.buyPrice = buyPrice;
		this.material = material;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Item)) {
			return false;
		}
		Item that = (Item) o;
		return Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", buyPrice=" + buyPrice + ", material=" + material
				+ ", color=" + color + "]";
	}
}
