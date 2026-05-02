package bean;

import java.util.Objects;

public class Trader {
	private String id;
	private String name;
	private String city;

	public Trader() {
	}

	public Trader(String id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Trader that)) {
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
		return "Trader [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
}
