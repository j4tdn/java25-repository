package persistence;

import java.util.Objects;

import converter.StatusConverter;
import enumeration.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t02_item_group")
public class ItemGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C02_ITEM_GROUP_ID")
	private Long id;

	@Column(name = "C02_ITEM_GROUP_NAME")
	private String name;

	@Convert(converter = StatusConverter.class)
	@Column(name = "C02_STATUS")
	private Status status;

	public ItemGroup() {
	}

	public ItemGroup(Long id, String name, Status status) {
		this.id = id;
		this.name = name;
		this.status = status;
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
