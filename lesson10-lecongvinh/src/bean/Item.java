package bean;

public class Item {
	
	private int Id;
	private String Name;
	private long SalesPrice;
	private int StoreId;

	
	public Item(int Id, String name, long salesPrice, int storeId) {
		
		this.Id = Id;
		this.Name = name;
		this.SalesPrice = salesPrice;
		this.StoreId = storeId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public long getSalesPrice() {
		return SalesPrice;
	}

	public void setSalesPrice(long salesPrice) {
		this.SalesPrice = salesPrice;
	}

	public int getStoreId() {
		return StoreId;
	}

	public void setStoreId(int storeId) {
		this.StoreId = storeId;
	}

	@Override
	public String toString() {
		return Id + ", " + Name + ", " + SalesPrice + ", " + StoreId + "\n";
	}

}
