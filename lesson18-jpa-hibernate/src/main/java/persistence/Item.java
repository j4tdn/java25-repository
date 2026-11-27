package persistence;

import java.math.BigDecimal;
import java.util.Objects;

import enumeration.Color;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t01_item")
public class Item {
	
	@Id
	@Column(name = "C01_ITEM_ID")
	private Long id;
	
	@Column(name = "C01_ITEM_NAME")
	private String name;
	
	@Column(name = "C01_BUY_PRICE")
	private BigDecimal buyPrice;
	
	@Column(name = "C01_MATERIAL")
	private String material;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "C01_COLOR")
	private Color color;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C01_ITEM_GROUP_ID", referencedColumnName = "C02_ITEM_GROUP_ID")
	private ItemGroup group;
	
	/**
	 * Required JPA constructor
	 */
	public Item() {
	}

	/**
	 * Constructor
	 */
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
	
	public ItemGroup getGroup() {
		return group;
	}
	
	public void setGroup(ItemGroup group) {
		this.group = group;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Item that)) {
			return false;
		}
		return Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", buyPrice=" + buyPrice + ", material=" + material + ", color="
				+ color + "]";
	}
}
