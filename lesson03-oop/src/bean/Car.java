package bean;

public class Car {

	// atrribute = thuộc tính = biến toàn cục
	//theo hướng phát triển oop:
	//- Mỗi class sẽ quản lý riêng của class đó -->> thuoc tinh trong class phải là private
	//
	private Integer id;
	private String model;
	private String name;
	private Double salesPrice;
	private Integer amount;

	// constructor mặc đinh
	public Car() {

	}

	// constructor
	public Car(Integer id, String model, String name, Double salesPrice) {
		this.id = id;
		this.model = model;
		this.name = name;
		this.salesPrice = salesPrice;
		this.amount = 1;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	@Override
	public boolean equals(Object o) {
		//quy ước 2 Car bằng nahu khi giống nhau id

		// Nếu 2 biến đối tượng cùng trỏ đến 1 ô nhớ tại HEAP
		// --> 2 biến đối tượng bằng nhau, khỏi so sánh
		if(this == o){
			return true;
		}
		// 2 biên trỏ đến 2 ô nhớ khác nhau tại HEAP
		// để gọi được hàm equals trong class Car thì chắc chắn là biến đối tượng Car mới gọi được --> this là Car
		// trước khi so sánh id của mỗi Car --> phải kiểm tra o có phải là Car lúc runtime hay không

		// nếu o ko phải là Car thì return false
		// nếu o là Car thì ép kiểu o từ Object sang Car lưu vào biên that (mục đích là để có Car gọi hàm getId())
		if(!(o instanceof Car that)){
			return false;
		}
		//so sanh id cuar 2 đối tượng
		return getId() = that.getId();

	}



	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", name=" + name + ", salesPrice=" + salesPrice + ", amount="
				+ amount + "]";
	}

	

}
