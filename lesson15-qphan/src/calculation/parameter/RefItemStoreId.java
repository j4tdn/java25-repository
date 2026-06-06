package calculation.parameter;

public class RefItemStoreId {
	
	private Long refItemId;
	private Long storeId;
	
	public RefItemStoreId(Long refItemId, Long storeId) {
		this.refItemId = refItemId;
		this.storeId = storeId;
	}
	
	public Long getRefItemId() {
		return refItemId;
	}
	
	public Long getStoreId() {
		return storeId;
	}
	
	
}
