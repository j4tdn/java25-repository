package bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import common.Color;

public class Apple implements Serializable {

	private static final long serialVersionUID = 4646960104812012155L;
	
	private Integer id;
	private Color color;
	private BigDecimal weight;
	private String originalCountry;

	public Apple() {
	}

	public Apple(Integer id, Color color, BigDecimal weight, String originalCountry) {
		this.id = id;
		this.color = color;
		this.weight = weight;
		this.originalCountry = originalCountry;
	}

	public Apple(String line) {
		String[] tokens = line.split(", ");
		if (tokens.length == 4) {
			this.id = Integer.parseInt(tokens[0]);
			this.color = Color.readValueFromString(tokens[1]);
			this.weight = new BigDecimal(tokens[2]);
			this.originalCountry = tokens[3];
		}
	}

	public static Apple cast(String line) {
		String[] tokens = line.split(", ");
		if (tokens.length == 4) {
			int id = Integer.parseInt(tokens[0]);
			Color color = Color.readValueFromString(tokens[1]);
			BigDecimal weight = new BigDecimal(tokens[2]);
			String country = tokens[3];
			return new Apple(id, color, weight, country);
		}
		return null;
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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Apple that)) {
			return false;
		}
		return getId() == that.getId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public String toString() {
		return "Apple [id=" + id + ", color=" + color + ", weight=" + weight + ", originalCountry=" + originalCountry
				+ "]";
	}
}