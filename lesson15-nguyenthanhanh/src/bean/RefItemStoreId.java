package bean;

import java.util.Objects;

public class RefItemStoreId {

	private Integer refItemId;
	private Integer storeId;
	
	public RefItemStoreId() {
		// TODO Auto-generated constructor stub
	}

	public RefItemStoreId(Integer refItemId, Integer storeId) {
		super();
		this.refItemId = refItemId;
		this.storeId = storeId;
	}

	public Integer getRefItemId() {
		return refItemId;
	}

	public void setRefItemId(Integer refItemId) {
		this.refItemId = refItemId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(refItemId, storeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RefItemStoreId other = (RefItemStoreId) obj;
		return Objects.equals(refItemId, other.refItemId) && Objects.equals(storeId, other.storeId);
	}
	
}
