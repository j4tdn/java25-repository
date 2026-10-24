package persistence;

import java.util.Objects;

public class ItemGroupDto {
	
	private Long id;
	private String name;
	private Integer amountOfItems;
	
	public ItemGroupDto() {
	}

	public ItemGroupDto(Long id, String name, Integer amountOfItems) {
		this.id = id;
		this.name = name;
		this.amountOfItems = amountOfItems;
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

	public Integer getAmountOfItems() {
		return amountOfItems;
	}

	public void setAmountOfItems(Integer amountOfItems) {
		this.amountOfItems = amountOfItems;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ItemGroupDto that)) {
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
		return "ItemGroupDto [id=" + id + ", name=" + name + ", amountOfItems=" + amountOfItems + "]";
	}
}
