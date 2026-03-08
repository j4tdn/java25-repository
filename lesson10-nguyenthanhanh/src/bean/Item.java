package bean;

public class Item {

	private Integer itemId;
    private String name;
    private Double salesPrice;
    private Integer storeId;
    
    public Item() {
    	
    }

	public Item(Integer itemId, String name, Double salesPrice, Integer storeId) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.salesPrice = salesPrice;
		this.storeId = storeId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
}
