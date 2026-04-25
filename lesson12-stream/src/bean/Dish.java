package bean;

import java.math.BigDecimal;
import java.util.Objects;

import common.Kind;

public class Dish {
	
	private String id;
	private String name;
	private BigDecimal calories;
	private Kind kind; // loại thức ăn

	public Dish() {
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
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof Dish that)) {
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
		return "Dish [id=" + id + ", name=" + name + ", calories=" + calories + ", kind=" + kind + "]";
	}
	
	
}
