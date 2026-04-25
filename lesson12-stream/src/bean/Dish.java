package bean;

import java.math.BigDecimal;
import java.util.Objects;

import common.Kind;

public class Dish {
	
	private String id;
	private String name;
	private BigDecimal calories;
	private Kind kind;
	
	public Dish() {
		// TODO Auto-generated constructor stub
	}

	public Dish(String id, String name, BigDecimal calories, Kind kind) {
		super();
		this.id = id;
		this.name = name;
		this.calories = calories;
		this.kind = kind;
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

	public BigDecimal getCalories() {
		return calories;
	}

	public void setCalories(BigDecimal calories) {
		this.calories = calories;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", calories=" + calories + ", kind=" + kind + "]";
	}

}
