package bean;

import java.math.BigDecimal;

import common.Color;

public class Apple {

	private Integer id;
	private Color color;
	private BigDecimal weight;
	private String originalCountry;
	
	public Apple() {
		
	}

	public Apple(Integer id, Color color, BigDecimal weight, String originalCountry) {
		super();
		this.id = id;
		this.color = color;
		this.weight = weight;
		this.originalCountry = originalCountry;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getOriginalCountry() {
		return originalCountry;
	}

	public void setOriginalCountry(String originalCountry) {
		this.originalCountry = originalCountry;
	}

	@Override
	public String toString() {
		return "Apple [id=" + id + ", color=" + color + ", weight=" + weight + ", originalCountry=" + originalCountry
				+ "]";
	}
	
}
