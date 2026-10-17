package persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import enumeration.Status;

public class ItemGroup {
	
	private Long id;
	private String name;
	private Status status;
	private List<Item> items = new ArrayList<>();
	
	public ItemGroup() {
	}

	public ItemGroup(Long id, String name, Status status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}
	
	public ItemGroup(ItemGroup itemGroup, List<Item> items) {
		this.id = itemGroup.id;
		this.name = itemGroup.name;
		this.status = itemGroup.status;
		this.items = items;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ItemGroup that)) {
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
		return "ItemGroup [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
}
